package com.example.groupchat.controller;

import com.example.groupchat.model.Groupchat;
import com.example.groupchat.model.Message;
import com.example.groupchat.service.GroupchatService;
import com.example.groupchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private GroupchatService groupchatService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/groupchats/{groupchatId}/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@PathVariable String groupchatId, @RequestBody Message message){
        Groupchat groupchat = groupchatService.findGroupChatByGroupchatId(groupchatId);
        Message createdMessage = messageService.addMessage(groupchatId, message);
        groupchat.getMessages().add(createdMessage);
        groupchat.getMessages().add(createdMessage);
        groupchatService.updateGroupchat(groupchat);
        return createdMessage;
    }

    @GetMapping("/groupchats/{groupchatId}/messages")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getAllMessagesByGroupchatId(@PathVariable String groupchatId){
        return messageService.findMessagesByGroupchatId(groupchatId);
    }

}
