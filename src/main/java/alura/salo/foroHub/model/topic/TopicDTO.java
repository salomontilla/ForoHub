package alura.salo.foroHub.model.topic;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
        @NotEmpty
        String title,
        @NotEmpty
        String message,
        @NotNull
        String autor,
        @NotNull
        Curse curse
) {
}
