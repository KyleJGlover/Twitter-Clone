package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.Like;
import com.twitter_backend.twitter_backend.repositorys.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like createLike(Like like) {
        if (like == null) {
            throw new IllegalArgumentException("like object cannot be null");
        }
        return likeRepository.save(like);
    }
}
