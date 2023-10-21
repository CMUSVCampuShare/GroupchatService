package com.example.groupchat.repository;

import com.example.groupchat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message,String>  {
    List<Message> findByGroupchatId(String groupchatId);
}
