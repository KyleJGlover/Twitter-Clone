package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.HashtagDTO;
import com.twitter_backend.twitter_backend.mappers.HashtagMapper;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.services.HashtagService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

    @Autowired
    private HashtagService hashtagService;

    @Autowired
    private HashtagMapper hashtagMapper;

    @PostMapping
    public ResponseEntity<HashtagDTO> createUpdateHashtag(@Valid @RequestBody(required = true) HashtagDTO hashtagDTO) {
    // Map the DTO to the entity
    Hashtag hashtag = hashtagMapper.toEntity(hashtagDTO);
    
    // Check if the hashtag exists by its ID
    Optional<Hashtag> existingHashtag = hashtagService.getHashtagById(hashtag.getId());

    if (existingHashtag.isPresent()) {
        // Update the existing hashtag
        hashtag = hashtagService.updateHashtag(hashtag.getId(), hashtag);
    } else {
        // Create the hashtag if it doesn't exist
        hashtag = hashtagService.createHashtag(hashtag);
    }

    // Convert back to DTO for verification
    HashtagDTO createdOrUpdateHashtagDTO = hashtagMapper.toDTO(hashtag);
    
    // Return the created or updated DTO in the response
    return new ResponseEntity<>(createdOrUpdateHashtagDTO, HttpStatus.CREATED);
    }

    @GetMapping("/hashtags/tweet/{tweetId}")
    public ResponseEntity<List<HashtagDTO>> getHashtagsByTweet(@NotEmpty @PathVariable(required = true) Long tweetId) {
        // Retrieve bookmarks associated with the provided tweet ID
        List<Hashtag> hashtags = hashtagService.getHashtagsByTweetId(tweetId);
        // Map the entities to DTOs
        List<HashtagDTO> hashtagDTOs = hashtagMapper.toDTOList(hashtags);
        // Return the DTOs in the response
        return new ResponseEntity<>(hashtagDTOs, HttpStatus.OK);
    }

    @GetMapping("/hashtags/user/{userId}")
    public ResponseEntity<List<HashtagDTO>> getHashtagsByUser(@NotEmpty @PathVariable(required = true) Long userId) {

        // Retrieve bookmarks associated with the provided user ID
        List<Hashtag> hashtags = hashtagService.getHashtagsByUserId(userId);

        // Map the entities to DTOs
        List<HashtagDTO> hashtagDTOs = hashtagMapper.toDTOList(hashtags);
        // Return the DTOs in the response
        return new ResponseEntity<>(hashtagDTOs, HttpStatus.OK);
    }
}
