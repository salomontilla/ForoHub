package alura.salo.foroHub.repository;

import alura.salo.foroHub.model.topic.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByStatusTrue(Pageable pageable);

    @Query("SELECT COUNT(t) > 0 FROM Topic t WHERE t.title = :title AND t.message = :message")
    boolean existsByTitleAndMessage(@Param("title") String title, @Param("message") String message);
}
