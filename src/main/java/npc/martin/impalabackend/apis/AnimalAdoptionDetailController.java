package npc.martin.impalabackend.apis;

import npc.martin.impalabackend.entity.AnimalAdoptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import npc.martin.impalabackend.services.AnimalAdoptionDetailService;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping("/api")
public class AnimalAdoptionDetailController {
    private final AnimalAdoptionDetailService animalDetailsService;
    
    @Autowired
    public AnimalAdoptionDetailController(AnimalAdoptionDetailService animalDetailsService) {
        this.animalDetailsService = animalDetailsService;
    }
    
    @PostMapping(value = "/animals/addAnimalDetails")
    public ResponseEntity<AnimalAdoptionDetail> addAnimalDetail(@RequestBody AnimalAdoptionDetail animalDetail) {
        animalDetailsService.addAnimalDetail(animalDetail);
        return new ResponseEntity<>(animalDetail, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/animals/updateAnimalDetails")
    public ResponseEntity<AnimalAdoptionDetail> updateAnimalDetail(@RequestBody AnimalAdoptionDetail animalDetail) {
        animalDetailsService.updateAnimalDetail(animalDetail);
        return new ResponseEntity<>(animalDetail, HttpStatus.OK);
    }
}
