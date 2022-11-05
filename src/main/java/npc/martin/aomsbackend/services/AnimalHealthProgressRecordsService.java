package npc.martin.aomsbackend.services;

import java.util.Optional;
import npc.martin.aomsbackend.entity.AnimalHealthProgressRecords;

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
