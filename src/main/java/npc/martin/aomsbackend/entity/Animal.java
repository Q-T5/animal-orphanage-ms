package npc.martin.aomsbackend.entity;

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
import org.hibernate.annotations.Proxy;

/**
 *
 * @author bikathi_martin
 */

@Entity
@Table(name = "animal")
@Proxy(lazy = false)
public class Animal {
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
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_animal_detail_id")
    private AnimalDetail animalDetail;

    public Animal() {
    }

    public Animal(String petName, String commonName, Integer age) {
        this.petName = petName;
        this.commonName = commonName;
        this.age = age;
    }

    public Integer getId() {
        return animalId;
    }

    public void setId(Integer id) {
        this.animalId = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AnimalDetail getAnimalDetail() {
        return animalDetail;
    }

    public void setAnimalDetail(AnimalDetail animalDetail) {
        this.animalDetail = animalDetail;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + animalId + ", petName=" + petName + ", commonName=" + commonName + ", age=" + age + '}';
    }
}
