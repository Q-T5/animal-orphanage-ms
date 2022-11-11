package npc.martin.impalabackend.apis;

import npc.martin.impalabackend.entity.AnimalAdoptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import npc.martin.impalabackend.services.AnimalAdoptionDetailService;

/**
 *
 * @author bikathi_martin
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:5173", "http://127.0.0.1:5173" } )
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
