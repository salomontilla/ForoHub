package alura.salo.foroHub.infra.errors;

import alura.salo.foroHub.infra.exceptions.TopicNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleTopicNotFoundException(TopicNotFoundException ex) {
        return ex.getMessage();
    }
}
