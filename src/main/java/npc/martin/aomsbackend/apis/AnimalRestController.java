package npc.martin.aomsbackend.apis;

import java.util.List;
import npc.martin.aomsbackend.advice.QueryEmptyResult;
import npc.martin.aomsbackend.entity.Animal;
import npc.martin.aomsbackend.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://127.0.0.1:5173" } )
public class AnimalRestController {
    private final AnimalService animalService;
    
    @Autowired
    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    } 
   
    @GetMapping(value = "/animals/getAllAnimals")
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> animalList = animalService.getAnimals();

        if(animalList.isEmpty()) {
            throw new QueryEmptyResult("Server responded with an empty result set.");
        }

        return new ResponseEntity<>(animalList, HttpStatus.OK);
    }
    
    @PostMapping(value = "/animals/createAnimal")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        animal.setId(0);
        animalService.createAnimal(animal);

        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/animals/getAnimal/{animalId}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer animalId) {
        Animal theAnimal = animalService.getAnimalById(animalId);

        if(theAnimal == null) {
            throw new QueryEmptyResult("Animal with ID: " + animalId + " not found.");
        }

        return new ResponseEntity<>(theAnimal, HttpStatus.OK);
    }
    
    @GetMapping(value = "/animal/searchAnimal/{animalId}")
    public ResponseEntity<Animal> searchAnimalById(@PathVariable Integer animalId) {
        Animal theAnimal = animalService.searchAnimalById(animalId);
        
        if(theAnimal == null) {
            throw new QueryEmptyResult("Animal with ID: " + animalId + " not found.");
        }

        return new ResponseEntity<>(theAnimal, HttpStatus.OK);
    }
    
    @PutMapping(value = "/animals/updateAnimal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) {
        animalService.updateAnimal(animal);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/animals/deleteAnimal/{animalId}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Integer animalId) {
        Animal theAnimal = animalService.getAnimalById(animalId);

        if(theAnimal == null) {
            throw new QueryEmptyResult("Animal with ID: " + animalId + " not found.");
        }
        animalService.deleteAnimal(theAnimal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
