package npc.martin.impalabackend.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author bikathi_martin
 */

@Proxy(lazy=false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "animal_adoption_detail")
public class AnimalAdoptionDetail implements Serializable {
    @Id
    @Column(name = "animal_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer animalId;
    
    @Column(name = "date_adopted")
    private LocalDate dateAdopted;
    
    @Column(name = "adoptee_name")
    private String adopteeName;
    
    @Column(name = "contact_number")
    private String contactNumber;
    
    @Column(name = "residential_location")
    private String residentialLocation;

    public AnimalAdoptionDetail(LocalDate dateAdopted, String adopteeName, String contactNumber, String residentialLocation) {
        this.dateAdopted = dateAdopted;
        this.adopteeName = adopteeName;
        this.contactNumber = contactNumber;
        this.residentialLocation = residentialLocation;
    }
}
