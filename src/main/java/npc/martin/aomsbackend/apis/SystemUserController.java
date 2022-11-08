package npc.martin.aomsbackend.apis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import npc.martin.aomsbackend.entity.Role;
import npc.martin.aomsbackend.entity.SystemRoles;
import npc.martin.aomsbackend.entity.SystemUser;
import npc.martin.aomsbackend.payload.request.LoginRequest;
import npc.martin.aomsbackend.payload.request.SignupRequest;
import npc.martin.aomsbackend.payload.response.JwtResponse;
import npc.martin.aomsbackend.payload.response.MessageResponse;
import npc.martin.aomsbackend.repository.SystemRoleRepository;
import npc.martin.aomsbackend.repository.SystemUserRepository;
import npc.martin.aomsbackend.security.jwt.JwtUtils;
import npc.martin.aomsbackend.services.SystemUserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bikathi_martin
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class SystemUserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private SystemUserRepository userRepository;
    
    @Autowired
    private SystemRoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getStaffId(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        SystemUserDetailsImpl userDetails = (SystemUserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());
        
        return new ResponseEntity(new JwtResponse(
            jwt, 
            userDetails.getStaffId(), 
            userDetails.getFirstName(), 
            roles), HttpStatus.OK);
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody SignupRequest signupRequest) {
        if(userRepository.existsByStaffId(signupRequest.getStaffId())) {
            return new ResponseEntity(new MessageResponse("Error: StaffId is Already Taken"), 
                HttpStatus.IM_USED);
        }
        
        //create a new user's account
        SystemUser user = new SystemUser(
                signupRequest.getStaffId(), 
                signupRequest.getFirstName(), 
                signupRequest.getLastName(), 
                passwordEncoder.encode(signupRequest.getPassword()), 
                signupRequest.getAccountStatus(), 
                passwordEncoder.encode(signupRequest.getRecoveryPhrase()), 
                null);
        
        Set<String> stringRoles = signupRequest.getStaffRoles();
        Set<Role> roles = new HashSet<>();
        
        if(stringRoles == null) {
            Role userRole = roleRepository.findByRoleName(SystemRoles.ROLE_EDITOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        } else {
            stringRoles.forEach(role -> {
                switch(role) {
                    case "admin":
                        Role adminRole = roleRepository.findByRoleName(SystemRoles.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is Not Found"));
                        roles.add(adminRole);
                        break;
                    case "editor":
                        Role editorRole = roleRepository.findByRoleName(SystemRoles.ROLE_EDITOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is Not Found"));
                        roles.add(editorRole);
                        break;
                    case "manager":
                        Role managerRole = roleRepository.findByRoleName(SystemRoles.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is Not Found"));
                        roles.add(managerRole);
                        break;
                    default:
                        Role editorRoleDefault = roleRepository.findByRoleName(SystemRoles.ROLE_EDITOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is Not Found"));
                        roles.add(editorRoleDefault);
                }
            });
        }
        
        user.setStaffRoles(roles);
        userRepository.save(user);
        return new ResponseEntity(new MessageResponse("User registered successfully"),HttpStatus.CREATED);
    }
}
