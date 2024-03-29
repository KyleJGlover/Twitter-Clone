package com.twitter_backend.twitter_backend.dto;

import jakarta.validation.constraints.NotNull;

public class UserDTO {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String email;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
