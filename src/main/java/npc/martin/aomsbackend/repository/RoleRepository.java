package npc.martin.aomsbackend.repository;

import java.util.Optional;
import npc.martin.aomsbackend.entity.Role;
import npc.martin.aomsbackend.entity.SystemRoles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bikathi_martin
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(SystemRoles name);
}
