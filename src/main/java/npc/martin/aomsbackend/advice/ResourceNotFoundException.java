package npc.martin.aomsbackend.advice;

/**
 *
 * @author bikathi_martin 
 * @date Jul 26, 2022
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException() { 
    }
}
