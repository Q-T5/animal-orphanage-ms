package npc.martin.impalabackend.services;

import npc.martin.impalabackend.entity.SystemUser;
import npc.martin.impalabackend.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bikathi_martin
 */
@Service
public class SystemUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SystemUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        SystemUser user = userRepository.findByStaffId(staffId)
            .orElseThrow(() -> new UsernameNotFoundException("Staff With That Id Not Found"));
        
        return SystemUserDetailsImpl.build(user);
    }
}
