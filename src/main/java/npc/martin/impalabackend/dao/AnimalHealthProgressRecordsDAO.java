package npc.martin.impalabackend.dao;

import npc.martin.impalabackend.entity.AnimalHealthProgressRecords;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface AnimalHealthProgressRecordsDAO extends MongoRepository<AnimalHealthProgressRecords, Integer> {
    
}
