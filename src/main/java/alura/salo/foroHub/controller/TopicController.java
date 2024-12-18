package alura.salo.foroHub.controller;

import alura.salo.foroHub.model.Topic;
import alura.salo.foroHub.model.TopicDTO;
import alura.salo.foroHub.model.TopicResponseDTO;
import alura.salo.foroHub.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody @Valid TopicDTO topicDTO, UriComponentsBuilder uriBuilder) {

        Topic newTopic = topicRepository.save(new Topic(topicDTO));
        TopicResponseDTO topicResponseDTO = new TopicResponseDTO(newTopic.getId(), newTopic.getTitle(), newTopic.getMessage(),
                newTopic.getCreationDate(), newTopic.getStatus(), newTopic.getAutor(), newTopic.getCurse());
        URI url = uriBuilder.path("/topics/{id}").buildAndExpand(newTopic.getId()).toUri();
        return ResponseEntity.created(url).body(topicResponseDTO);
    }
}
