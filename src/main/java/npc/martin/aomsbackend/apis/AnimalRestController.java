package npc.martin.aomsbackend.apis;

import java.util.List;
import npc.martin.aomsbackend.advice.ResourceNotFoundException;
import npc.martin.aomsbackend.entity.Animal;
import npc.martin.aomsbackend.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 */

@RestController
@RequestMapping("/api")
public class AnimalRestController {
    private final AnimalService animalService;
    
    @Autowired
    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    } 
   
    @GetMapping(value = "/animals/getAllAnimals")
    public ResponseEntity<List<Animal>> getAnimals() throws Exception {
        try {
            List<Animal> animalList = animalService.getAnimals();

            if(animalList.isEmpty()) {
                throw new ResourceNotFoundException("No animal records found.");
            }

            return new ResponseEntity<>(animalList, HttpStatus.FOUND);
        } catch(Exception ex) {
            throw new Exception("Request failed to go through.");
        }
    }
    
    @PostMapping(value = "/animals/createAnimal")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) throws Exception {
        try {
            animal.setId(0);
            animalService.createAnimal(animal);

            return new ResponseEntity<>(animal, HttpStatus.CREATED);
        } catch(Exception ex) {
            throw new Exception("Request failed to go through.");
        }
        
    }
    
    @GetMapping(value = "/animals/getAnimal/{animalId}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer animalId) throws Exception {
        try {
            Animal theAnimal = animalService.getAnimalById(animalId);

            if(theAnimal == null) {
                throw new ResourceNotFoundException("No animal for id: " + animalId + "found.");
            }

            return new ResponseEntity<>(theAnimal, HttpStatus.FOUND); 
        } catch(Exception ex) {
            throw new Exception("Request failed to go through.");
        }
    }
    
    @PutMapping(value = "/animals/updateAnimal")
    public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) throws Exception {
        try {
            animalService.updateAnimal(animal);
            return new ResponseEntity<>(animal, HttpStatus.OK);
        } catch(Exception ex) {
            throw new Exception("Request failed to go through.");
        }
    }
    
    @DeleteMapping(value = "/animals/deleteAnimal/{animalId}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Integer animalId) throws Exception {
        try {
            Animal theAnimal = animalService.getAnimalById(animalId);
        
            if(theAnimal == null) {
                throw new ResourceNotFoundException("No animal for id: " + animalId + "found.");
            }
            animalService.deleteAnimal(theAnimal);
        return new ResponseEntity<>(null, HttpStatus.OK);
            
        } catch(Exception ex) {
            throw new Exception("Request failed to go through.");
        }
    }
}
