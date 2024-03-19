package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.ReplyDTO;
import com.twitter_backend.twitter_backend.mappers.ReplyMapper;
import com.twitter_backend.twitter_backend.models.Reply;
import com.twitter_backend.twitter_backend.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyMapper replyMapper;

    @PostMapping
    public ResponseEntity<ReplyDTO> createReply(@RequestBody ReplyDTO replyDTO) {
        Reply reply = replyMapper.toEntity(replyDTO);
        reply = replyService.createReply(reply);
        ReplyDTO createdReplyDTO = replyMapper.toDTO(reply);
        return new ResponseEntity<>(createdReplyDTO, HttpStatus.CREATED);
    }
}
