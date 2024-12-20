package alura.salo.foroHub.model.topic;

public record UpdateTopicDTO(
        Long id,
        String title,
        String message
) {
}
