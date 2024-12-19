package alura.salo.foroHub.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404Handler(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400handler(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(ErrorsDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorsDTO(String error, String mensaje) {
        public ErrorsDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
