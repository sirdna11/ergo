package com.example.project1.api.controller;

import com.example.project1.api.model.User;
import com.example.project1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.save(user);
        LOGGER.info("User with PersonalID {} was added", user.getPersonalID());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam String personalID){
        LOGGER.info("Request to get User with PersonalID {}", personalID);
        List<User> users = userService.getUser(personalID);
        if (users.isEmpty()) {
            LOGGER.warn("No User found with PersonalID {}", personalID);
        }
        return users;
    }
}
