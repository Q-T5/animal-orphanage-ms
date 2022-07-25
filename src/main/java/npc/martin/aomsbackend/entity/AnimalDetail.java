package npc.martin.aomsbackend.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author bikathi_martin
 */

@Entity
@Table(name = "animal_detail")
@Proxy(lazy=false)
public class AnimalDetail {
    @Id
    @Column(name = "animal_id")
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

    public Integer getId() {
        return animalId;
    }

    public LocalDate getDateBrought() {
        return dateBrought;
    }

    public LocalDate getDateAdopted() {
        return dateAdopted;
    }

    public String getAdopteeName() {
        return adopteeName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getResidentialLocation() {
        return residentialLocation;
    }

    @Override
    public String toString() {
        return "AnimalDetail{" + "id=" + animalId + ", dateBrought=" + dateBrought + ", dateAdopted=" + dateAdopted + ", adopteeName=" + adopteeName + ", contactNumber=" + contactNumber + ", residentialLocation=" + residentialLocation + '}';
    }
}
