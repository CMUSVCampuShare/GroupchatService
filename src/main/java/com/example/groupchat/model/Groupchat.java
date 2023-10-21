package com.example.groupchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "groupchats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupchat {
    @Id
    private String groupchatId;
    private String groupchatName;
    private List<User> users;
    private List<Message> messages;
}
