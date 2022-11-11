package npc.martin.impalabackend.apis;

import npc.martin.impalabackend.entity.SystemUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bikathi_martin
 */

@RestController
@CrossOrigin(origins = { "http://localhost:5173", "http://127.0.0.1:5173" } )
@RequestMapping(value = "/api")
public class SystemUsersDBController {
    @GetMapping(value = "/user/getUser")
    public ResponseEntity<?> getStaffById(@RequestParam String staffId) {
        return null;
    }
    
    @GetMapping(value = "/user/getAllUsers")
    public ResponseEntity<?> getAllStaff(@RequestParam Integer page) {
        return null;
    }
    
    @PutMapping(value = "/user/updateUser")
    public ResponseEntity<?> updateStaff(@RequestBody SystemUser user) {
        return null;
    }
    
    @DeleteMapping(value = "/user/deleteUser")
    public ResponseEntity<?> deleteStaff(@RequestParam String staffId) {
        return null;
    }
}
