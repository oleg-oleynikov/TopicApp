package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.MessageDTO;
import org.example.entity.Message;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;
    private UserService userService;

    public Message saveMessage(MessageDTO dto){
        return messageRepository.save(Message.builder()
                .textMessage(dto.getTextMessage())
                .user(userService.readUserById(dto.getUserId()))
                .build());
    }
    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    public Message getMessageById(Long messageId){
        return messageRepository.findById(messageId).orElseThrow(() -> new RuntimeException("Ну нету"));
    }

    public Message updateMessage(Message message){
        return messageRepository.save(message);
    }

    public void deleteMessage(Long messageId){
        messageRepository.deleteById(messageId);
    }
}
