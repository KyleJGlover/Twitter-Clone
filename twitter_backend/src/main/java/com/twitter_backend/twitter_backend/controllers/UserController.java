package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.UserDTO;
import com.twitter_backend.twitter_backend.mappers.UserMapper;
import com.twitter_backend.twitter_backend.models.User;
import com.twitter_backend.twitter_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Map the DTO to the entity
        User user = userMapper.toEntity(userDTO);
        // Create the hashtag using the service
        user = userService.createUser(user);
        // Convert back to DTO for verfication
        UserDTO createdUserDTO = userMapper.toDTO(user);
        // Return the created DTO in the response
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }
}
