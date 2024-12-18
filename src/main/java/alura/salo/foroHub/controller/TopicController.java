package alura.salo.foroHub.controller;

import alura.salo.foroHub.model.TopicDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @PostMapping
    public void createTopic(@RequestBody @Valid TopicDTO topicDTO) {
        System.out.println("Creating a new topic");
    }
}
