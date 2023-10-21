package com.example.groupchat.manager;

import com.example.groupchat.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
    public User getUserDetails(String userId){
        //Call user service to user location details
        return new User();
    }
}
