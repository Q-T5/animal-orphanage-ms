package npc.martin.aomsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import npc.martin.aomsbackend.entity.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
