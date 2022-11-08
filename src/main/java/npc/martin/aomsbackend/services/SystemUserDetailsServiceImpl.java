package npc.martin.aomsbackend.services;

import npc.martin.aomsbackend.entity.SystemUser;
import npc.martin.aomsbackend.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bikathi_martin
 */
@Service
public class SystemUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        SystemUser user = userRepository.findByStaffId(staffId)
            .orElseThrow(() -> new UsernameNotFoundException("Staff With That Id Not Found"));
        
        return SystemUserDetailsImpl.build(user);
    }
}
