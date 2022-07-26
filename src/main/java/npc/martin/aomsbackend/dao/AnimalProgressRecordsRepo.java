package npc.martin.aomsbackend.dao;

import npc.martin.aomsbackend.entity.AnimalProgressRecords;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface AnimalProgressRecordsRepo extends MongoRepository<AnimalProgressRecords, Integer> {
    
}
