package npc.martin.aomsbackend.services;

import java.util.Optional;
import npc.martin.aomsbackend.dao.AnimalProgressRecordsRepo;
import npc.martin.aomsbackend.entity.AnimalProgressRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */
@Service
public class AnimalProgressRecordsServiceImpl implements AnimalProgressRecordsService {
    private AnimalProgressRecordsRepo animalProgressRecordsRepo;

    public AnimalProgressRecordsServiceImpl() {
    }
    
    @Autowired
    public AnimalProgressRecordsServiceImpl(AnimalProgressRecordsRepo animalProgressRecordsRepo) {
        this.animalProgressRecordsRepo = animalProgressRecordsRepo;
    }

    @Override
    public Optional<AnimalProgressRecords> getAnimalDetails(Integer animalId) {
        Optional<AnimalProgressRecords> animalProgressRecords = animalProgressRecordsRepo.findById(animalId);
        return animalProgressRecords;
    }

    @Override
    public AnimalProgressRecords createAnimalProgressRecord(AnimalProgressRecords animalProgressRecord) {
        animalProgressRecordsRepo.save(animalProgressRecord);
        return animalProgressRecord;
    }

    @Override
    public AnimalProgressRecords updateAnimalProgressRecord(AnimalProgressRecords animalProgressRecords) {
        return animalProgressRecordsRepo.save(animalProgressRecords);
    }

    @Override
    public void deleteAnimalProgressRecord(Integer animalId) {
        animalProgressRecordsRepo.deleteById(animalId);
    }
}
