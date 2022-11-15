package npc.martin.impalabackend.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import npc.martin.impalabackend.entity.SystemUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bikathi_martin
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SystemUserDetailsImpl implements UserDetails {
    private String staffId;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean accountActive;
    private Collection<? extends GrantedAuthority> authorities;
    
    public static SystemUserDetailsImpl build(SystemUser user) {
        List<GrantedAuthority> authorities = user.getStaffRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
            .collect(Collectors.toList());
        
        return new SystemUserDetailsImpl(
            user.getStaffId(),
            user.getFirstName(),
            user.getLastName(),
            user.getPassword(),
            user.getAccountActive(),
            authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountActive;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        SystemUserDetailsImpl user = (SystemUserDetailsImpl) obj;
        return Objects.equals(staffId, user.staffId);
    }   
}
