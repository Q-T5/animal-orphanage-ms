package npc.martin.aomsbackend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */

@Document(collection = "healthprogressrecords")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnimalHealthProgressRecords {
    @Id
    private Integer animalId;
    private ClinicalState clinicalState;
    private String whereFound;
    private String foods;
    private List<MedicalProgress> medicalProgress;
    
    public void updateMedicalProgress(MedicalProgress medicalProgressUpdate) {
        if(this.medicalProgress == null) {
            this.medicalProgress = new ArrayList<>();
        }
        
        this.medicalProgress.add(medicalProgressUpdate);
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class ClinicalState {
    private Float weight;
    private Integer numberOfChildren;
    private String medicalState;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class MedicalProgress {
    private LocalDate checkupDate;
    private String checkupNotes;
    private LocalDate nextCheckupDate;
}
