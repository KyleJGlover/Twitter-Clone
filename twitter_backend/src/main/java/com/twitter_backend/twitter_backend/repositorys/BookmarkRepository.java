package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.Bookmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByTweetId(Long tweetId);
    List<Bookmark> findByUserId(Long userId);
}
