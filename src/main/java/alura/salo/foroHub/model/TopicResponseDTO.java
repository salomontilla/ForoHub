package alura.salo.foroHub.model;

import java.time.LocalDateTime;

public record TopicResponseDTO (
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        boolean status,
        String autor,
        Curse curse
){
}
