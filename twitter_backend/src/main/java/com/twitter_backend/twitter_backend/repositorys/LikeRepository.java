package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.Like;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByTweetId(Long tweetId);
    List<Like> findByUserId(Long userId);
}