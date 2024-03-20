package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.BookmarkDTO;
import com.twitter_backend.twitter_backend.mappers.BookmarkMapper;
import com.twitter_backend.twitter_backend.models.Bookmark;
import com.twitter_backend.twitter_backend.services.BookmarkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @Autowired
    private BookmarkMapper bookmarkMapper;

    @PostMapping
    public ResponseEntity<BookmarkDTO> createBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
        // Map the DTO to the entity
        Bookmark bookmark = bookmarkMapper.toEntity(bookmarkDTO);
        // Create the bookmark using the service
        bookmark = bookmarkService.createBookmark(bookmark);
        // Convert back to DTO for verification
        BookmarkDTO createdBookmarkDTO = bookmarkMapper.toDTO(bookmark);
        // Return the created DTO in the response
        return new ResponseEntity<>(createdBookmarkDTO, HttpStatus.CREATED);
    }

    @GetMapping("/bookmarks/tweet/{tweetId}")
    public ResponseEntity<List<BookmarkDTO>> getBookmarksByTweet(@PathVariable Long tweetId) {
        // Retrieve bookmarks associated with the provided tweet ID
        List<Bookmark> bookmarks = bookmarkService.getBookmarksByTweetId(tweetId);
        // Map the entities to DTOs
        List<BookmarkDTO> bookmarkDTOs = bookmarkMapper.toDTOList(bookmarks);
        // Return the DTOs in the response
        return new ResponseEntity<>(bookmarkDTOs, HttpStatus.OK);
    }

    @GetMapping("/bookmarks/user/{userId}")
    public ResponseEntity<List<BookmarkDTO>> getBookmarksByUser(@PathVariable Long userId) {
        // Retrieve bookmarks associated with the provided user ID
        List<Bookmark> bookmarks = bookmarkService.getBookmarksByUserId(userId);
        // Map the entities to DTOs
        List<BookmarkDTO> bookmarkDTOs = bookmarkMapper.toDTOList(bookmarks);
        // Return the DTOs in the response
        return new ResponseEntity<>(bookmarkDTOs, HttpStatus.OK);
    }
}
