package com.twitter_backend.twitter_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.twitter_backend.twitter_backend.dto.TweetDTO;
import com.twitter_backend.twitter_backend.mappers.TweetMapper;
import com.twitter_backend.twitter_backend.models.Tweet;
import com.twitter_backend.twitter_backend.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private TweetMapper tweetMapper;

    @PostMapping
    public ResponseEntity<TweetDTO> createTweet(@RequestBody TweetDTO tweetDTO) {
        Tweet tweet = tweetMapper.toEntity(tweetDTO);
        tweet = tweetService.createTweet(tweet);
        TweetDTO createdTweetDTO = tweetMapper.toDTO(tweet);
        return new ResponseEntity<>(createdTweetDTO, HttpStatus.CREATED);
    }
}
