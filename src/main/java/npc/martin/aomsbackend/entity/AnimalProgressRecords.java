package npc.martin.aomsbackend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */

@Document(collection = "progressrecords")
public class AnimalProgressRecords {
    @Id
    private Integer animalId;
    private ClinicalState clinicalState;
    private String whereFound;
    private String foods;
    private List<MedicalProgress> medicalProgress;

    public AnimalProgressRecords() {
    }

    public AnimalProgressRecords(Integer animalId, ClinicalState clinicalState, String whereFound, String foods, List<MedicalProgress> medicalProgress) {
        this.animalId = animalId;
        this.clinicalState = clinicalState;
        this.whereFound = whereFound;
        this.foods = foods;
        this.medicalProgress = medicalProgress;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public ClinicalState getClinicalState() {
        return clinicalState;
    }

    public void setClinicalState(ClinicalState clinicalState) {
        this.clinicalState = clinicalState;
    }

    public String getWhereFound() {
        return whereFound;
    }

    public void setWhereFound(String whereFound) {
        this.whereFound = whereFound;
    }

    public String getFoods() {
        return foods;
    }

    public void setFoods(String foods) {
        this.foods = foods;
    }

    public List<MedicalProgress> getMedicalProgress() {
        return medicalProgress;
    }

    public void setMedicalProgress(List<MedicalProgress> medicalProgress) {
        this.medicalProgress = medicalProgress;
    }

    @Override
    public String toString() {
        return "AnimalProgressRecords{" + "animalId=" + animalId + ", clinicalState=" + clinicalState + ", whereFound=" + whereFound + ", foods=" + foods + ", medicalProgress=" + medicalProgress + '}';
    }
    
    public void updateMedicalProgress(MedicalProgress medicalProgressUpdate) {
        if(this.medicalProgress == null) {
            this.medicalProgress = new ArrayList<>();
        }
        
        this.medicalProgress.add(medicalProgressUpdate);
    }
}

class ClinicalState {
    private Float weight;
    private Integer numberOfChildren;
    private String medicalState;

    public ClinicalState(Float weight, Integer numberOfChildren, String medicalState) {
        this.weight = weight;
        this.numberOfChildren = numberOfChildren;
        this.medicalState = medicalState;
    }

    public ClinicalState() {
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getMedicalState() {
        return medicalState;
    }

    public void setMedicalState(String medicalState) {
        this.medicalState = medicalState;
    }

    @Override
    public String toString() {
        return "ClinicalState{" + "weight=" + weight + ", numberOfChildren=" + numberOfChildren + ", medicalState=" + medicalState + '}';
    }
}

class MedicalProgress {
    private LocalDate checkupDate;
    private String checkupNotes;
    private LocalDate nextCheckupDate;

    public MedicalProgress() {
    }

    public MedicalProgress(LocalDate checkupDate, String checkupNotes, LocalDate nextCheckupDate) {
        this.checkupDate = checkupDate;
        this.checkupNotes = checkupNotes;
        this.nextCheckupDate = nextCheckupDate;
    }

    public LocalDate getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(LocalDate checkupDate) {
        this.checkupDate = checkupDate;
    }

    public String getCheckupNotes() {
        return checkupNotes;
    }

    public void setCheckupNotes(String checkupNotes) {
        this.checkupNotes = checkupNotes;
    }

    public LocalDate getNextCheckupDate() {
        return nextCheckupDate;
    }

    public void setNextCheckupDate(LocalDate nextCheckupDate) {
        this.nextCheckupDate = nextCheckupDate;
    }

    @Override
    public String toString() {
        return "MedicalProgress{" + "checkupDate=" + checkupDate + ", checkupNotes=" + checkupNotes + ", nextCheckupDate=" + nextCheckupDate + '}';
    }
}
