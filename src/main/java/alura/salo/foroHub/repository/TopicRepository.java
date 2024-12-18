package alura.salo.foroHub.repository;

import alura.salo.foroHub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
