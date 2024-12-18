package alura.salo.foroHub.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
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
        this.status = topicDTO.status();
        this.autor = topicDTO.autor();
        this.curse = topicDTO.curse();
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime createDate() {
        return LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")));
    }
}
