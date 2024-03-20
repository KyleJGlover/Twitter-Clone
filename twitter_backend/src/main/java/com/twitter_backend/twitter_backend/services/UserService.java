package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.User;
import com.twitter_backend.twitter_backend.repositorys.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user object cannot be null");
        }
        return userRepository.save(user);
    }
}