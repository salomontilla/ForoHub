package alura.salo.foroHub.controller;

import alura.salo.foroHub.model.topic.Topic;
import alura.salo.foroHub.model.topic.TopicDTO;
import alura.salo.foroHub.model.topic.TopicResponseDTO;
import alura.salo.foroHub.model.topic.UpdateTopicDTO;
import alura.salo.foroHub.model.topic.validations.DuplicatedTopicValidator;
import alura.salo.foroHub.repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    DuplicatedTopicValidator duplicatedTopicValidator;

    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody @Valid TopicDTO topicDTO, UriComponentsBuilder uriBuilder) {
        duplicatedTopicValidator.validate(new Topic(topicDTO));

        Topic newTopic = topicRepository.save(new Topic(topicDTO));
        TopicResponseDTO topicResponseDTO = new TopicResponseDTO(newTopic.getId(), newTopic.getTitle(), newTopic.getMessage(),
                newTopic.getCreationDate(), newTopic.getStatus(), newTopic.getAutor(), newTopic.getCurse());
        URI url = uriBuilder.path("/topics/{id}").buildAndExpand(newTopic.getId()).toUri();
        return ResponseEntity.created(url).body(topicResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponseDTO>> showTopics(Pageable pageable){
        return ResponseEntity.ok(topicRepository.findByStatusTrue(pageable).map(TopicResponseDTO::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity <TopicResponseDTO> updateTopic(@RequestBody @Valid UpdateTopicDTO topic){
        Topic newTopic = topicRepository.getReferenceById(topic.id());newTopic.updateTopic(topic);
        return ResponseEntity.ok(new TopicResponseDTO(newTopic.getId(), newTopic.getTitle(), newTopic.getMessage(),
                newTopic.getCreationDate(), newTopic.getStatus(), newTopic.getAutor(), newTopic.getCurse()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id){
        Topic topic = topicRepository.getReferenceById(id);
        topic.deactivateTopic();
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<TopicResponseDTO>showTopic(@PathVariable Long id){
        return ResponseEntity.ok(topicRepository.findByIdAndStatusTrue(id));
    }

}
