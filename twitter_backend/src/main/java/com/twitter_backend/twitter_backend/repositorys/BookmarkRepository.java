package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.Bookmark;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUserId(Long userId);
    List<Bookmark> findByTweetId(Long tweetId);
}
