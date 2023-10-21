package com.example.groupchat.repository;

import com.example.groupchat.model.Groupchat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupchatRepository extends MongoRepository<Groupchat,String> {
    Groupchat findByGroupchatName(String groupchatName);
}
