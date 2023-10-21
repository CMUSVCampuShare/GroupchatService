package com.example.groupchat.service;

import com.example.groupchat.model.Groupchat;
import com.example.groupchat.repository.GroupchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.swing.*;
import java.util.List;
import java.util.UUID;

@Service
public class GroupchatService {

    @Autowired
    private GroupchatRepository groupchatRepository;

    public Groupchat addGroupchat(Groupchat groupchat) {
        groupchat.setGroupchatId(UUID.randomUUID().toString().split("-")[0]);
        return groupchatRepository.save(groupchat);
    }

    public List<Groupchat> findAllGroupchats() {
        return groupchatRepository.findAll();
    }

    public Groupchat findGroupChatByGroupchatId(String groupchatId) {
        return groupchatRepository.findById(groupchatId).get();
    }

    public Groupchat findGroupChatByGroupchatName(String groupchatName) {
        return groupchatRepository.findByGroupchatName(groupchatName);
    }

    public Groupchat updateGroupchat(Groupchat groupchatRequest) {
        Groupchat existingGroupchat = groupchatRepository.findById(groupchatRequest.getGroupchatId()).get();
        existingGroupchat.setUsers(groupchatRequest.getUsers());
        existingGroupchat.setMessages(groupchatRequest.getMessages());
        return groupchatRepository.save(existingGroupchat);
    }

}
