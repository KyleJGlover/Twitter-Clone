package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.HashtagDTO;
import com.twitter_backend.twitter_backend.mappers.HashtagMapper;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.services.HashtagService;

import java.util.List;

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
    public ResponseEntity<HashtagDTO> createHashtag(@RequestBody HashtagDTO hashtagDTO) {
        // Map the DTO to the entity
        Hashtag hashtag = hashtagMapper.toEntity(hashtagDTO);
        // Create the hashtag using the service
        hashtag = hashtagService.createHashtag(hashtag);      
        // Convert back to DTO for verfication
        HashtagDTO createdHashtagDTO = hashtagMapper.toDTO(hashtag);
        // Return the created DTO in the response
        return new ResponseEntity<>(createdHashtagDTO, HttpStatus.CREATED);
    }

    @GetMapping("/hashtags/tweet/{tweetId}")
    public ResponseEntity<List<HashtagDTO>> getHashtagsByTweet(@PathVariable Long tweetId) {
        if (tweetId == null) {
            return ResponseEntity.badRequest().build(); // Invalid request, tweetId is missing
        }
        // Retrieve bookmarks associated with the provided tweet ID
        List<Hashtag> hashtags = hashtagService.getHashtagsByTweetId(tweetId);

        // Map the entities to DTOs
        List<HashtagDTO> hashtagDTOs = hashtagMapper.toDTOList(hashtags);
        // Return the DTOs in the response
        return new ResponseEntity<>(hashtagDTOs, HttpStatus.OK);
    }

    @GetMapping("/hashtags/user/{userId}")
    public ResponseEntity<List<HashtagDTO>> getHashtagsByUser(@PathVariable Long userId) {
        // Retrieve bookmarks associated with the provided user ID
        List<Hashtag> hashtags = hashtagService.getHashtagsByUserId(userId);
        // Map the entities to DTOs
        List<HashtagDTO> hashtagDTOs = hashtagMapper.toDTOList(hashtags);
        // Return the DTOs in the response
        return new ResponseEntity<>(hashtagDTOs, HttpStatus.OK);
    }
}
