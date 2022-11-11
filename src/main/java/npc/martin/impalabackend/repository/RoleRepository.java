package npc.martin.impalabackend.repository;

import java.util.Optional;
import npc.martin.impalabackend.entity.Role;
import npc.martin.impalabackend.entity.SystemRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(SystemRoles name);
}
