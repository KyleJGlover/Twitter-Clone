package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.repositorys.HashtagRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashtagService {

    private HashtagRepository hashtagRepository;

    public List<Hashtag> getAllHashtags() {
        List<Hashtag> hashtags = hashtagRepository.findAll();
        return hashtags;
    }

    public Hashtag createHashtag(Hashtag hashtag) {
        if(!CheckIfValid(hashtag))
            return hashtag;
        // Check if the hashtag already exists
        Hashtag existingHashtag = hashtagRepository.findByName(hashtag.getName());

        if(!CheckIfValid(existingHashtag))
            return existingHashtag;

        return hashtagRepository.save(hashtag);
    }

    public List<Hashtag> getHashtagsByTweetId(Long tweetId){
        if(!CheckIfValid(tweetId))
            return List.of();
        return hashtagRepository.findByTweetId(tweetId);
    }

    public List<Hashtag> getHashtagsByUserId(Long userId){
        if(!CheckIfValid(userId))
            return List.of();
        return hashtagRepository.findByTweetId(userId);
    }

    private Boolean CheckIfValid(Hashtag hashtag){
        if (hashtag == null) {
            return false;
        }
        
        if (hashtag.getId()== null || hashtag.getName() == null) {
            return false;
        }
        return true;
    }

    private Boolean CheckIfValid(Long id){
        return id == null ? false: true;
    }
}
