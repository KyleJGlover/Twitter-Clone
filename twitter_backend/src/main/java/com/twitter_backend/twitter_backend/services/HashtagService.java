package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.exceptions.ResourceNotFoundException;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.repositorys.HashtagRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HashtagService {

    private HashtagRepository hashtagRepository;

    @Transactional
    public List<Hashtag> getAllHashtags() {
        return hashtagRepository.findAll();
    }
    @Transactional
    public Hashtag createHashtag(Hashtag hashtag) {
        return hashtagRepository.save(hashtag);
    }

    
    @Transactional
    public Hashtag updateHashtag(Long id, Hashtag updatedHashtag) {
        Hashtag existingHashtag = hashtagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hashtag not found with id: " + id));

        // Update the properties of the existingHashtag with the properties of the updatedHashtag
        existingHashtag.setName(updatedHashtag.getName());

        // Save the updatedHashtag in the database
        return hashtagRepository.save(existingHashtag);
    }
    @Transactional
    public Optional<Hashtag> getHashtagById(Long id){
        return hashtagRepository.findById(id);
    }
    @Transactional
    public List<Hashtag> getHashtagsByTweetId(Long tweetId){
        return hashtagRepository.findByTweetId(tweetId);
    }
    @Transactional
    public List<Hashtag> getHashtagsByUserId(Long userId){
        return hashtagRepository.findByTweetId(userId);
    }
    
// Not necessary to validate at this stage but if complexity goes up yes
    // private Boolean CheckIfValid(Hashtag hashtag){
    //     if (hashtag == null) {
    //         return false;
    //     }
        
    //     if (hashtag.getId()== null || hashtag.getName() == null) {
    //         return false;
    //     }
    //     return true;
    // }

    // private Boolean CheckIfValid(Long id){
    //     return id == null ? false: true;
    // }
}
