package com.example.groupchat.repository;

import com.example.groupchat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>  {
}
