package npc.martin.aomsbackend.payload.request;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import npc.martin.aomsbackend.entity.Role;

/**
 *
 * @author bikathi_martin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupRequest {
    private String staffId;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean accountStatus;
    private String recoveryPhrase;
    private Set<Role> staffRoles = new HashSet<>();
}
