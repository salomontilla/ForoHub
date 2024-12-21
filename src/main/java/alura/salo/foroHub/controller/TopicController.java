package alura.salo.foroHub.controller;

import alura.salo.foroHub.infra.exceptions.TopicNotFoundException;
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
import java.util.Optional;

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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity <TopicResponseDTO> updateTopic(@RequestBody @Valid UpdateTopicDTO topic, @PathVariable Long id){
        topicNotFoundException(id);
        Topic newTopic = topicRepository.getReferenceById(id);
        newTopic.updateTopic(topic);
        duplicatedTopicValidator.validate(newTopic);
        return ResponseEntity.ok(new TopicResponseDTO(newTopic.getId(), newTopic.getTitle(), newTopic.getMessage(),
                newTopic.getCreationDate(), newTopic.getStatus(), newTopic.getAutor(), newTopic.getCurse()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity <Object> deleteTopic(@PathVariable @Valid Long id){
        topicNotFoundException(id);
        topicRepository.deleteById(id);
        //topic.deactivateTopic();
        return ResponseEntity.ok("Topic with id " + id + " was successfully deleted.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO>showTopic(@PathVariable @Valid Long id){
        topicNotFoundException(id);
        return ResponseEntity.ok(topicRepository.findByIdAndStatusTrue(id));
    }

    public void topicNotFoundException(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isEmpty()) {
            throw new TopicNotFoundException("Topic not found with id: " + id);
        }
    }

}
