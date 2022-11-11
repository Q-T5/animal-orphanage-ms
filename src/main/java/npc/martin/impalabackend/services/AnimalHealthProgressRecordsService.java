package npc.martin.impalabackend.services;

import java.util.Optional;
import npc.martin.impalabackend.entity.AnimalHealthProgressRecords;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalHealthProgressRecordsService {
    public Optional<AnimalHealthProgressRecords> getAnimalDetails(Integer animalId);
    public AnimalHealthProgressRecords createAnimalProgressRecord(AnimalHealthProgressRecords animalProgressRecord);
    public AnimalHealthProgressRecords updateAnimalProgressRecord(AnimalHealthProgressRecords animalProgressRecords);
    public void deleteAnimalProgressRecord(Integer animalId);
}
