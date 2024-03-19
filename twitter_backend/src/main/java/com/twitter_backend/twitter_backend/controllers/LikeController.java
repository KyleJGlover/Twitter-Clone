package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.LikeDTO;
import com.twitter_backend.twitter_backend.mappers.LikeMapper;
import com.twitter_backend.twitter_backend.models.Like;
import com.twitter_backend.twitter_backend.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeMapper likeMapper;

    @PostMapping
    public ResponseEntity<LikeDTO> createLike(@RequestBody LikeDTO likeDTO) {
        Like like = likeMapper.toEntity(likeDTO);
        like = likeService.createLike(like);
        LikeDTO createdLikeDTO = likeMapper.toDTO(like);
        return new ResponseEntity<>(createdLikeDTO, HttpStatus.CREATED);
    }
}