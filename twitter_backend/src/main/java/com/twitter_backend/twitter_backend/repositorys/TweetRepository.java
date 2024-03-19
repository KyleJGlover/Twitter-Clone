package com.twitter_backend.twitter_backend.repositorys;

import com.twitter_backend.twitter_backend.models.Bookmark;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.models.Like;
import com.twitter_backend.twitter_backend.models.Reply;
import com.twitter_backend.twitter_backend.models.Tweet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    // Multiple ways to query
    // @Query("SELECT t FROM Tweet t JOIN t.hashtags h WHERE h.name = :hashtagName")
    // List<Tweet> findByHashtagName(@Param("hashtagName") String hashtagName);

    // @Query("SELECT t FROM Tweet t JOIN t.hashtags h WHERE h.name IN :hashtagNames")
    // List<Tweet> findByHashtagNames(@Param("hashtagNames") List<String> hashtagNames);

    List<Like> findLikesByAuthorId(Long authorId);
    List<Reply> findRepliesByAuthorId(Long authorId);
    List<Bookmark> findBookmarksByAuthorId(Long authorId);
    List<Hashtag> findHashtagsByAuthorId(Long authorId);
}
