package npc.martin.aomsbackend.repository;

import npc.martin.aomsbackend.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    
}
