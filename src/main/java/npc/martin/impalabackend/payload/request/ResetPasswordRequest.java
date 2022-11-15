package npc.martin.impalabackend.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bikathi_martin
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResetPasswordRequest {
    private String staffId;
    private String password;
}
