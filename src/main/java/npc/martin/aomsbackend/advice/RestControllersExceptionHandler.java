package npc.martin.aomsbackend.advice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author bikathi_martin
 * @date Jul 26, 2022
 */
@RestControllerAdvice
public class RestControllersExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, dd-MM-yyyy HH:mm:ss")),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(QueryEmptyResult.class)
    public ResponseEntity<ErrorMessage> queryReturnedEmptyResult(QueryEmptyResult ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.NO_CONTENT.value(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, dd-MM-yyyy HH:mm:ss")),
            ex.getMessage(),
            request.getDescription(false));
        
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> otherException(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("E, dd-MM-yyyy HH:mm:ss")),
            ex.getMessage(),
            request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
