package com.example.project1.service;


import com.example.project1.api.model.User;
import com.example.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUser(String personalID){
        return userRepository.findByPersonalID(personalID);
    }
    public User save(User user) {
        userRepository.save(user);
        return user;
    }


}




