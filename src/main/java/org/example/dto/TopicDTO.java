package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicDTO {
    private String name;
    private List<MessageDTO> messages;
}
