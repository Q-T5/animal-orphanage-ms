package npc.martin.aomsbackend.services;

import npc.martin.aomsbackend.entity.SystemUser;
import npc.martin.aomsbackend.repository.SystemUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(SystemUserDetailsServiceImpl.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        SystemUser user = userRepository.findByStaffId(staffId)
            .orElseThrow(() -> new UsernameNotFoundException("Staff With That Id Not Found"));
        
        logger.info("Found staff with id: {}", staffId);
        return SystemUserDetailsImpl.build(user);
    }
}
