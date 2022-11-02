package npc.martin.aomsbackend.entity;

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

@Entity
@Table(name = "animal_detail")
@Proxy(lazy=false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnimalDetail {
    @Id
    @Column(name = "animal_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer animalId;
    
    @Column(name = "date_brought")
    private LocalDate dateBrought;
    
    @Column(name = "date_adopted")
    private LocalDate dateAdopted;
    
    @Column(name = "adoptee_name")
    private String adopteeName;
    
    @Column(name = "contact_number")
    private String contactNumber;
    
    @Column(name = "residential_location")
    private String residentialLocation;

    public AnimalDetail() {
    }

    public AnimalDetail(Integer id, LocalDate dateBrought, LocalDate dateAdopted, String adopteeName, String contactNumber, String residentialLocation) {
        this.animalId = id;
        this.dateBrought = dateBrought;
        this.dateAdopted = dateAdopted;
        this.adopteeName = adopteeName;
        this.contactNumber = contactNumber;
        this.residentialLocation = residentialLocation;
    }

    public AnimalDetail(LocalDate dateBrought, LocalDate dateAdopted, String adopteeName, String contactNumber, String residentialLocation) {
        this.dateBrought = dateBrought;
        this.dateAdopted = dateAdopted;
        this.adopteeName = adopteeName;
        this.contactNumber = contactNumber;
        this.residentialLocation = residentialLocation;
    }
}
