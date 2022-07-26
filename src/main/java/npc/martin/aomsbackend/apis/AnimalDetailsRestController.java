package npc.martin.aomsbackend.apis;

import npc.martin.aomsbackend.entity.AnimalDetail;
import npc.martin.aomsbackend.services.AnimalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class AnimalDetailsRestController {
    private final AnimalDetailsService animalDetailsService;
    
    @Autowired
    public AnimalDetailsRestController(AnimalDetailsService animalDetailsService) {
        this.animalDetailsService = animalDetailsService;
    }
    
    @PostMapping(value = "/animals/addAnimalDetails")
    public ResponseEntity<AnimalDetail> addAnimalDetail(@RequestBody AnimalDetail animalDetail) {
        animalDetailsService.addAnimalDetail(animalDetail);
        return new ResponseEntity<>(animalDetail, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/animals/updateAnimalDetails")
    public ResponseEntity<AnimalDetail> updateAnimalDetail(@RequestBody AnimalDetail animalDetail) {
        animalDetailsService.updateAnimalDetail(animalDetail);
        return new ResponseEntity<>(animalDetail, HttpStatus.OK);
    }
}
