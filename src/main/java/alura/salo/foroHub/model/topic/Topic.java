package alura.salo.foroHub.model.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private boolean status;
    private String autor;
    @Enumerated(EnumType.STRING) @Column(name = "curse")
    private Curse curse;

    public Topic(TopicDTO topicDTO) {
        this.title = topicDTO.title();
        this.message = topicDTO.message();
        this.creationDate = createDate();
        this.status = true;
        this.autor = topicDTO.autor();
        this.curse = topicDTO.curse();
    }

    public Topic() {
    }

    public LocalDateTime createDate() {
        return LocalDateTime.now();
    }

    public void updateTopic(UpdateTopicDTO updateTopicDTO) {
        this.title = updateTopicDTO.title();
        this.message = updateTopicDTO.message();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public Curse getCurse() {
        return curse;
    }

    public void deactivateTopic() {
        this.status = false;
    }
}
