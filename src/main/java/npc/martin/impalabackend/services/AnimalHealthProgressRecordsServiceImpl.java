package npc.martin.impalabackend.services;

import java.util.Optional;
import npc.martin.impalabackend.entity.AnimalHealthProgressRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import npc.martin.impalabackend.dao.AnimalHealthProgressRecordsDAO;


/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */
@Service
public class AnimalHealthProgressRecordsServiceImpl implements AnimalHealthProgressRecordsService {
    private AnimalHealthProgressRecordsDAO animalProgressRecordsDAO;

    public AnimalHealthProgressRecordsServiceImpl() {
    }
    
    @Autowired
    public AnimalHealthProgressRecordsServiceImpl(AnimalHealthProgressRecordsDAO animalProgressRecordsDAO) {
        this.animalProgressRecordsDAO = animalProgressRecordsDAO;
    }

    @Override
    public Optional<AnimalHealthProgressRecords> getAnimalDetails(Integer animalId) {
        Optional<AnimalHealthProgressRecords> animalProgressRecords = animalProgressRecordsDAO.findById(animalId);
        return animalProgressRecords;
    }

    @Override
    public AnimalHealthProgressRecords createAnimalProgressRecord(AnimalHealthProgressRecords animalProgressRecord) {
        animalProgressRecordsDAO.save(animalProgressRecord);
        return animalProgressRecord;
    }

    @Override
    public AnimalHealthProgressRecords updateAnimalProgressRecord(AnimalHealthProgressRecords animalProgressRecords) {
        return animalProgressRecordsDAO.save(animalProgressRecords);
    }

    @Override
    public void deleteAnimalProgressRecord(Integer animalId) {
        animalProgressRecordsDAO.deleteById(animalId);
    }
}
