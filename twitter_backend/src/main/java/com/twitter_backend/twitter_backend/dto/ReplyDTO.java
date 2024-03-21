package com.twitter_backend.twitter_backend.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class ReplyDTO {
    private Long id;
    @NotNull
    private String text;
    @NotNull
    private Long userId;
    @NotNull
    private Long tweetId;
    private Long replyId;
    private LocalDateTime createdAt;

    // Constructors
    public ReplyDTO() {
    }

    public ReplyDTO(String text, Long userId, Long tweetId, Long replyId, LocalDateTime createdAt) {
        this.text = text;
        this.userId = userId;
        this.tweetId = tweetId;
        this.replyId = replyId;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
