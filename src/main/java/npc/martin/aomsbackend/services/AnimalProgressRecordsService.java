package npc.martin.aomsbackend.services;

import java.util.Optional;
import npc.martin.aomsbackend.entity.AnimalProgressRecords;

/**
 *
 * @author bikathi_martin
 */
public interface AnimalProgressRecordsService {
    public Optional<AnimalProgressRecords> getAnimalDetails(Integer animalId);
    public AnimalProgressRecords createAnimalProgressRecord(AnimalProgressRecords animalProgressRecord);
    public AnimalProgressRecords updateAnimalProgressRecord(AnimalProgressRecords animalProgressRecords);
    public void deleteAnimalProgressRecord(Integer animalId);
}
