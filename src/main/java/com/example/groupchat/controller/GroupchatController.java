package com.example.groupchat.controller;

import com.example.groupchat.model.Groupchat;
import com.example.groupchat.service.GroupchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupchatController {

    @Autowired
    private GroupchatService groupchatService;

    @PostMapping("/groupchats")
    @ResponseStatus(HttpStatus.CREATED)
    public Groupchat createGroupchat(@RequestBody Groupchat groupchat){
        // Add logic to check if the group chat already exists! Need userId and/or userLocation for that!!
        return groupchatService.addGroupchat(groupchat);
    }

    @GetMapping("/groupchats")
    @ResponseStatus(HttpStatus.OK)
    public List<Groupchat> getAllGroupchats(){
        return groupchatService.findAllGroupchats();
    }

    @GetMapping("/groupchats/{groupchatId}")
    @ResponseStatus(HttpStatus.OK)
    public Groupchat getGroupchatByGroupchatId(@PathVariable String groupchatId){
        return groupchatService.findGroupChatByGroupchatId(groupchatId);
    }

    @PutMapping("/groupchats/{groupchatId}")
    @ResponseStatus(HttpStatus.OK)
    public Groupchat editGroupchat(@RequestBody Groupchat groupchat){
        return groupchatService.updateGroupchat(groupchat);
    }
}
