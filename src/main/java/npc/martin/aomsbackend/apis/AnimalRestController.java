package npc.martin.aomsbackend.apis;

import java.util.List;
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
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> animalList = animalService.getAnimals();
        
        if(animalList.isEmpty()) {
            //replace this with custom exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(animalList, HttpStatus.FOUND);
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
            //replace this with custom exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(theAnimal, HttpStatus.FOUND);
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
            return new ResponseEntity<>("Animal Not Found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        animalService.deleteAnimal(theAnimal);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
