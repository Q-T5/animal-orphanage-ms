package npc.martin.aomsbackend.payload.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bikathi_martin
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String staffId;
    private String firstName;
    private List<String> roles;

    public JwtResponse(String token, String staffId, String firstName, List<String> roles) {
        this.token = token;
        this.staffId = staffId;
        this.firstName = firstName;
        this.roles = roles;
    }
}
