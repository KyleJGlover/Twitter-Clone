package com.twitter_backend.twitter_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.twitter_backend.twitter_backend.models.Tweet;
import com.twitter_backend.twitter_backend.repositorys.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Transactional
    public Tweet createTweet(Tweet tweet) {
        if (tweet == null) {
            throw new IllegalArgumentException("tweet object cannot be null");
        }
        return tweetRepository.save(tweet);
    }
}
