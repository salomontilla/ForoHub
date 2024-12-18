package alura.salo.foroHub.model;

import jakarta.validation.constraints.NotBlank;
public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        boolean status,
        @NotBlank
        String autor,
        @NotBlank
        Curse curse
) {
}
