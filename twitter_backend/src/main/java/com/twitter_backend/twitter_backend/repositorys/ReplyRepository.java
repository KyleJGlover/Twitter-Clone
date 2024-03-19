package com.twitter_backend.twitter_backend.repositorys;
import com.twitter_backend.twitter_backend.models.Reply;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByUserId(Long userId);
    List<Reply> findByTweetId(Long tweetId);
}
