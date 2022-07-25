package npc.martin.aomsbackend.repository;

import npc.martin.aomsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bikathi_martin
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
