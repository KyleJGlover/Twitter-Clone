package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.models.Bookmark;
import com.twitter_backend.twitter_backend.repositorys.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public Bookmark createBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    // Other service methods using bookmarkRepository
}
