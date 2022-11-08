package npc.martin.aomsbackend.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author bikathi_martin
 */

@Entity
@Table(name = "staff_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SystemUser {
    @Id
    @Column(name = "staff_id")
    private String staffId;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "account_status")
    private Boolean accountStatus; //0 for active 1 for disabled
    
    @Column(name = "recovery_phrase")
    private String recoveryPhrase;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "staff_detail_role",
        joinColumns = { @JoinColumn(name = "staff_id") },
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> staffRoles;
}
