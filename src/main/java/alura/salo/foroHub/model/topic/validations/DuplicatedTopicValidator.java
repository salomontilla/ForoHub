package alura.salo.foroHub.model.topic.validations;

import alura.salo.foroHub.model.topic.Topic;
import alura.salo.foroHub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicatedTopicValidator {
    @Autowired
    TopicRepository topicRepository;

    public void validate(Topic topic) {
        var duplicatedTopic = topicRepository.existsByTitleAndMessage(topic.getTitle(), topic.getMessage());
        if(duplicatedTopic) {
            throw new RuntimeException("There is already a topic with the same title and message");
        }
    }
}
