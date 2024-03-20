package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.Bookmark;
import com.twitter_backend.twitter_backend.repositorys.BookmarkRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// https://phsophea101.medium.com/standard-api-request-and-response-with-spring-boot-f3a7cf7f4422
// FIX FIX FIX add standard classes for handling request errors

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @SuppressWarnings("null")
    public Bookmark createBookmark(Bookmark bookmark) {
        if(!CheckIfValid(bookmark))
            return bookmark;
        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> getBookmarksByTweetId(Long tweetId){
        if(!CheckIfValid(tweetId))
            return List.of();
        return bookmarkRepository.findByTweetId(tweetId);
    }

    public List<Bookmark> getBookmarksByUserId(Long userId){
        if(!CheckIfValid(userId))
            return List.of();
        return bookmarkRepository.findByTweetId(userId);
    }

    private Boolean CheckIfValid(Bookmark bookmark){
        if (bookmark == null) {
            return false;
        }
        
        if (bookmark.getTweet() == null || bookmark.getUser() == null || bookmark.getCreatedAt() == null) {
            return false;
        }
        return true;
    }

    private Boolean CheckIfValid(Long id){
        return id == null ? false: true;
    }
}
