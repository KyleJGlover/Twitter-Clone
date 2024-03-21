package com.twitter_backend.twitter_backend.dto;

import jakarta.validation.constraints.NotNull;

public class HashtagDTO {
    private Long id;
    @NotNull
    private String name;

    // Constructors
    public HashtagDTO() {
    }

    public HashtagDTO(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

