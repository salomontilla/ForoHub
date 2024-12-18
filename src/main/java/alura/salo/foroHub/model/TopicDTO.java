package alura.salo.foroHub.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        LocalDateTime creationDate,
        @NotBlank
        boolean status,
        @NotBlank
        String autor,
        @NotBlank
        Curse curse
) {
}
