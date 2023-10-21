package com.example.groupchat.service;

import com.example.groupchat.model.Message;
import com.example.groupchat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message addMessage(String groupchatId, Message message) {
        message.setMessageId(UUID.randomUUID().toString().split("-")[0]);
        message.setGroupchatId(groupchatId);
        return messageRepository.save(message);
    }

    public List<Message> findMessagesByGroupchatId(String groupchatId) {
        return messageRepository.findByGroupchatId(groupchatId);
    }
}
