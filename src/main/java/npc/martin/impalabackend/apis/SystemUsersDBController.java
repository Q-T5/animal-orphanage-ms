package npc.martin.impalabackend.apis;

import java.util.ArrayList;
import java.util.List;
import npc.martin.impalabackend.advice.ResourceNotFoundException;
import npc.martin.impalabackend.entity.SystemUser;
import npc.martin.impalabackend.entity.SystemUsersListEntity;
import npc.martin.impalabackend.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://127.0.0.1:5173" })
public class SystemUsersDBController {
    @Autowired
    private SystemUserRepository systemUserRepository;
    
    @GetMapping(value = "/user/getUser")
    public ResponseEntity<?> getStaffById(@RequestParam String staffId) {
        SystemUser staff = systemUserRepository.findByStaffId(staffId)
            .orElseThrow(() -> new ResourceNotFoundException("Staff With ID: " + staffId + "Not Found!"));
        
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
    
    @GetMapping(value = "/user/getAllUsers")
    public ResponseEntity<?> getAllStaff(@RequestParam Integer page) {
        //pagination request with Jpa
        PageRequest pageWithTenElements = PageRequest.of(page, 10);
        
        //findAll() request returns a defult Page<T> entity that is actually a collection
        //so we convert it into a List<SystemUser>
        Page<SystemUser> usersList = systemUserRepository.findAll(pageWithTenElements);
        List<SystemUsersListEntity> listOfUsers = new ArrayList<>();
        
        for(SystemUser user : usersList) {
            SystemUsersListEntity userInList = new SystemUsersListEntity(
                user.getStaffId(), 
                user.getFirstName(), 
                user.getLastName(), 
                user.getPassword(), 
                user.getAccountActive(), 
                new ArrayList<>());
            
            user.getStaffRoles().forEach(role -> {
                switch(role.getRoleName().name()) {
                    case "ROLE_ADMIN" -> {
                        userInList.getStaffRoles().add("admin");
                        break;
                    }
                    
                    case "ROLE_EDITOR" -> {
                        userInList.getStaffRoles().add("editor");
                        break;
                    }
                    
                    case "ROLE_MANAGER" -> {
                        userInList.getStaffRoles().add("manager");
                        break;
                    }
                }
            });
            
            listOfUsers.add(userInList);
        }
        
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }
    
    @PutMapping(value = "/user/updateUser")
    public ResponseEntity<?> updateStaff(@RequestBody SystemUser staff) {
        Boolean staffExists = systemUserRepository.existsByStaffId(staff.getStaffId());
        
        if(staffExists != true) {
            throw new ResourceNotFoundException("Staff With ID: " + staff.getStaffId() + "Not Found!");
        }
        
        systemUserRepository.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/user/deleteUser")
    public ResponseEntity<?> deleteStaff(@RequestParam String staffId) {
        SystemUser staff = systemUserRepository.findByStaffId(staffId)
            .orElseThrow(() -> new ResourceNotFoundException("Staff With ID: " + staffId + "Not Found!"));
        
        systemUserRepository.delete(staff);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
