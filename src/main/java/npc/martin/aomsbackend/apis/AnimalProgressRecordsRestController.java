package npc.martin.aomsbackend.apis;

import java.time.LocalDate;
import java.util.Optional;
import npc.martin.aomsbackend.advice.ResourceNotFoundException;
import npc.martin.aomsbackend.entity.AnimalProgressRecords;
import npc.martin.aomsbackend.services.AnimalProgressRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://127.0.0.1:5173" } )
public class AnimalProgressRecordsRestController {
    public AnimalProgressRecordsService animalProgressRecordsService;

    public AnimalProgressRecordsRestController() {
    }
    
    @Autowired
    public AnimalProgressRecordsRestController(AnimalProgressRecordsService animalProgressRecordsService) {
        this.animalProgressRecordsService = animalProgressRecordsService;
    }
    
    @GetMapping(value = "/animals/getAnimalRecord/{animalId}")
    public ResponseEntity<AnimalProgressRecords> getAnimalRecord(@PathVariable Integer animalId) {
        Optional<AnimalProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalId);

        if(theRecordsContainer.isPresent()) {
            return new ResponseEntity<>(theRecordsContainer.get(), HttpStatus.FOUND);
        } else {
            throw new ResourceNotFoundException("Animal progress records for the id: " + animalId + "do not exist.");
        }
    }
    
    @PostMapping(value = "/animals/newAnimalRecord")
    public ResponseEntity<AnimalProgressRecords> createAnimalRecord(@RequestBody AnimalProgressRecords animalProgressRecord) {
        AnimalProgressRecords createdRecords = animalProgressRecordsService.createAnimalProgressRecord(animalProgressRecord);
        return new ResponseEntity<>(createdRecords, HttpStatus.CREATED);
    }
    
    @PutMapping("/animals/updateAnimalRecord")
    public ResponseEntity<AnimalProgressRecords> updateAnimalRecord(@RequestBody AnimalProgressRecords animalProgressRecord) {
        Optional<AnimalProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalProgressRecord.getAnimalId());
        AnimalProgressRecords currentAnimalProgressRecord = null;

        if(theRecordsContainer.isPresent()) {
            currentAnimalProgressRecord = theRecordsContainer.get();
        } else {
            throw new ResourceNotFoundException("Animal progress records for the id: " + animalProgressRecord.getAnimalId() + "do not exist.");
        }

        currentAnimalProgressRecord.setClinicalState(animalProgressRecord.getClinicalState());
        currentAnimalProgressRecord.setFoods(animalProgressRecord.getFoods());
        currentAnimalProgressRecord.setMedicalProgress(animalProgressRecord.getMedicalProgress());
        currentAnimalProgressRecord.setWhereFound(animalProgressRecord.getWhereFound());

        animalProgressRecordsService.updateAnimalProgressRecord(currentAnimalProgressRecord);
        return new ResponseEntity<>(currentAnimalProgressRecord, HttpStatus.OK);
    }
    
    @DeleteMapping("/animals/deleteAnimalRecord/{animalId}")
    public ResponseEntity<String> deleteAnimalRecord(@PathVariable Integer animalId) {
        Optional<AnimalProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalId);
        
        if(theRecordsContainer.isEmpty()) {
            throw new ResourceNotFoundException("No animal for id: " + animalId + " found.");
        }
        
        animalProgressRecordsService.deleteAnimalProgressRecord(animalId);
        return new ResponseEntity<>("Successfully deleted records for animal with id: " + animalId, HttpStatus.OK);
    }
    
}
