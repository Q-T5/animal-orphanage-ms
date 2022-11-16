package npc.martin.impalabackend.apis;

import java.util.Optional;
import npc.martin.impalabackend.advice.QueryEmptyResult;
import npc.martin.impalabackend.entity.AnimalHealthProgressRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import npc.martin.impalabackend.services.AnimalHealthProgressRecordsService;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */

@RestController
@RequestMapping("/api")
public class AnimalProgressRecordsController {
    public AnimalHealthProgressRecordsService animalProgressRecordsService;

    public AnimalProgressRecordsController() {
    }
    
    @Autowired
    public AnimalProgressRecordsController(AnimalHealthProgressRecordsService animalProgressRecordsService) {
        this.animalProgressRecordsService = animalProgressRecordsService;
    }
    
    @GetMapping(value = "/animals/getAnimalRecord/{animalId}")
    public ResponseEntity<AnimalHealthProgressRecords> getAnimalRecord(@PathVariable Integer animalId) {
        Optional<AnimalHealthProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalId);

        if(theRecordsContainer.isPresent()) {
            return new ResponseEntity<>(theRecordsContainer.get(), HttpStatus.FOUND);
        } else {
            throw new QueryEmptyResult("Animal progress records for the id: " + animalId + "do not exist.");
        }
    }
    
    @PostMapping(value = "/animals/newAnimalRecord")
    public ResponseEntity<AnimalHealthProgressRecords> createAnimalRecord(@RequestBody AnimalHealthProgressRecords animalProgressRecord) {
        AnimalHealthProgressRecords createdRecords = animalProgressRecordsService.createAnimalProgressRecord(animalProgressRecord);
        return new ResponseEntity<>(createdRecords, HttpStatus.CREATED);
    }
    
    @PutMapping("/animals/updateAnimalRecord")
    public ResponseEntity<AnimalHealthProgressRecords> updateAnimalRecord(@RequestBody AnimalHealthProgressRecords animalProgressRecord) {
        Optional<AnimalHealthProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalProgressRecord.getAnimalId());
        AnimalHealthProgressRecords currentAnimalProgressRecord = null;

        if(theRecordsContainer.isPresent()) {
            currentAnimalProgressRecord = theRecordsContainer.get();
        } else {
            throw new QueryEmptyResult("Animal progress records for the id: " + animalProgressRecord.getAnimalId() + "do not exist.");
        }

        currentAnimalProgressRecord.setFoods(animalProgressRecord.getFoods());
        currentAnimalProgressRecord.setMedicalProgress(animalProgressRecord.getMedicalProgress());
        currentAnimalProgressRecord.setWhereFound(animalProgressRecord.getWhereFound());

        animalProgressRecordsService.updateAnimalProgressRecord(currentAnimalProgressRecord);
        return new ResponseEntity<>(currentAnimalProgressRecord, HttpStatus.OK);
    }
    
    @DeleteMapping("/animals/deleteAnimalRecord/{animalId}")
    public ResponseEntity<String> deleteAnimalRecord(@PathVariable Integer animalId) {
        Optional<AnimalHealthProgressRecords> theRecordsContainer = animalProgressRecordsService.getAnimalDetails(animalId);
        
        if(theRecordsContainer.isEmpty()) {
            throw new QueryEmptyResult("No animal for id: " + animalId + " was found.");
        }
        
        animalProgressRecordsService.deleteAnimalProgressRecord(animalId);
        return new ResponseEntity<>("Successfully deleted records for animal with id: " + animalId, HttpStatus.OK);
    }
    
}
