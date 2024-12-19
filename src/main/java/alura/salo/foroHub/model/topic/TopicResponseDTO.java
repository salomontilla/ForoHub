package alura.salo.foroHub.model.topic;

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
    public TopicResponseDTO(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(),
                topic.getStatus(), topic.getAutor(), topic.getCurse());
    }
}
