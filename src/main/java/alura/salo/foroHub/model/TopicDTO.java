package alura.salo.foroHub.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record TopicDTO(
        String title,
        String message,
        LocalDateTime creationDate,
        boolean status,
        String autor,
        Curse curse
) {
}
