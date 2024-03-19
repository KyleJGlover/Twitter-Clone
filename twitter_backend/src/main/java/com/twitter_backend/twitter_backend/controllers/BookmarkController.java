package com.twitter_backend.twitter_backend.controllers;

import com.twitter_backend.twitter_backend.dto.BookmarkDTO;
import com.twitter_backend.twitter_backend.mappers.BookmarkMapper;
import com.twitter_backend.twitter_backend.models.Bookmark;
import com.twitter_backend.twitter_backend.services.BookmarkService;
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
        Bookmark bookmark = bookmarkMapper.toEntity(bookmarkDTO);
        bookmark = bookmarkService.createBookmark(bookmark);
        BookmarkDTO createdBookmarkDTO = bookmarkMapper.toDTO(bookmark);
        return new ResponseEntity<>(createdBookmarkDTO, HttpStatus.CREATED);
    }
}
