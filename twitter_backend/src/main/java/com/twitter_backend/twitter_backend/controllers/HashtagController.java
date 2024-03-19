package com.twitter_backend.twitter_backend.controllers;


import com.twitter_backend.twitter_backend.dto.HashtagDTO;
import com.twitter_backend.twitter_backend.mappers.HashtagMapper;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.services.HashtagService;
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
        Hashtag hashtag = hashtagMapper.dtoToHashtag(hashtagDTO);
    
        // Create the hashtag using the service
        HashtagDTO createdHashtagDTO = hashtagService.createHashtag(hashtag.getName());
        
        // Return the created hashtag DTO in the response
        return new ResponseEntity<>(createdHashtagDTO, HttpStatus.CREATED);
    }
}
