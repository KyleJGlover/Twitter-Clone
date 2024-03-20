package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.Reply;
import com.twitter_backend.twitter_backend.repositorys.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply createReply(Reply reply) {
        if (reply == null) {
            throw new IllegalArgumentException("reply object cannot be null");
        }
        return replyRepository.save(reply);
    }
}