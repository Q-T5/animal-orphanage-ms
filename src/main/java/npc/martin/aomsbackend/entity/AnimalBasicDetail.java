package npc.martin.aomsbackend.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "animal_basic_detail")
@Proxy(lazy = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AnimalBasicDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer animalId;
    
    @Column(name = "pet_name")
    private String petName;
    
    @Column(name = "common_name")
    private String commonName;
    
    @Column(name = "age_years")
    private Integer age;
            
    @Column(name = "date_brought")
    private LocalDate dateBrought;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_animal_detail_id")
    private AnimalAdoptionDetail animalDetail;

    public AnimalBasicDetail(String petName, String commonName, Integer age) {
        this.petName = petName;
        this.commonName = commonName;
        this.age = age;
    }
}
