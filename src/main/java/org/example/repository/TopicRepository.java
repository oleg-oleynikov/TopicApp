package org.example.repository;

import org.example.entity.Message;
import org.example.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Message> findMessagesByTopicId(Long id);
}
