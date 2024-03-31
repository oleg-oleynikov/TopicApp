package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.TopicDTO;
import org.example.entity.Message;
import org.example.entity.Topic;
import org.example.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    private TopicRepository topicRepository;
    private MessageService messageService;
    private UserService userService;

    public List<Topic> readAll(){
        return topicRepository.findAll();
    }

    public List<Message> readAllMessagesInTopic(Long topicId){
        return topicRepository.findMessagesByTopicId(topicId);
    }

    public void deleteTopicById(Long topicId){
        topicRepository.deleteById(topicId);
    }

    public Topic createTopic(TopicDTO dto){
        Topic topic = Topic.builder()
                .name(dto.getName())
                .build();

        topicRepository.save(topic);

        List<Message> messages = dto.getMessages()
                .stream()
                .map(messageDTO -> messageService.saveMessage(Message.builder()
                        .topic(topic)
                        .user(userService.readUserById(messageDTO.getUserId()))
                        .textMessage(messageDTO.getTextMessage())
                        .build())
                )
                .toList();
        topic.setMessages(messages);
        return updateTopic(topic);
    }

    public Topic updateTopic(Topic topic){
        return topicRepository.save(topic);
    }
}
