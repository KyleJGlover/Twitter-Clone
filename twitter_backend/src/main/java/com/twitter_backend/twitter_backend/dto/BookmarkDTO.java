package com.twitter_backend.twitter_backend.dto;

import java.time.LocalDateTime;

public class BookmarkDTO {
    private Long id;
    private Long userId;
    private Long tweetId;
    private LocalDateTime createdAt;

    // Constructors
    public BookmarkDTO() {
    }

    public BookmarkDTO(Long userId, Long tweetId, LocalDateTime createdAt) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}