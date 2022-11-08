package npc.martin.aomsbackend.repository;

import java.util.Optional;
import npc.martin.aomsbackend.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, String> {
    Optional<SystemUser> findByStaffId(String staffId);
    Boolean existsByStaffId(String staffId);
    Boolean existsByFirstName(String firstName);
}
