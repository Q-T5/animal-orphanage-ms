package npc.martin.aomsbackend.services;

import npc.martin.aomsbackend.entity.SystemUser;
import npc.martin.aomsbackend.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author bikathi_martin
 */
public class SystemUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        SystemUser user = userRepository.findByStaffId(staffId)
            .orElseThrow(() -> new UsernameNotFoundException("User With That Id Not Found"));
        
        return SystemUserDetailsImpl.build(user);
    }
}
