package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MessageDTO {
    private String textMessage;
    private LocalDate sendDate;
    private Long userId;
    private Long topicId;
}
