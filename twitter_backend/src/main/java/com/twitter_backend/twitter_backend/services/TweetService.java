package com.twitter_backend.twitter_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twitter_backend.twitter_backend.exceptions.ResourceNotFoundException;
import com.twitter_backend.twitter_backend.models.Tweet;
import com.twitter_backend.twitter_backend.repositorys.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Transactional
    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }
    @Transactional
    public Tweet createTweet(Tweet Tweet) {
        return tweetRepository.save(Tweet);
    }

    
    @Transactional
    public Tweet updateTweet(Long id, Tweet updatedTweet) {
        Tweet existingTweet = tweetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tweet not found with id: " + id));

        // Update the properties of the existingTweet with the properties of the updatedTweet
        existingTweet.updateTweet(updatedTweet);

        // Save the updatedTweet in the database
        return tweetRepository.save(existingTweet);
    }
    @Transactional
    public Optional<Tweet> getTweetById(Long id){
        return tweetRepository.findById(id);
    }
    @Transactional
    public List<Tweet> getTweetsByTweetId(Long tweetId){
        return tweetRepository.findByTweetId(tweetId);
    }
    @Transactional
    public List<Tweet> getTweetsByUserId(Long userId){
        return tweetRepository.findByUserId(userId);
    }
}
