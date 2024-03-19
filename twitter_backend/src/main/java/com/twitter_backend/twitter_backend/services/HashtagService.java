package com.twitter_backend.twitter_backend.services;

import com.twitter_backend.twitter_backend.dto.HashtagDTO;
import com.twitter_backend.twitter_backend.mappers.HashtagMapper;
import com.twitter_backend.twitter_backend.models.Hashtag;
import com.twitter_backend.twitter_backend.repositorys.HashtagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;
    private final HashtagMapper hashtagMapper;

    public HashtagService(HashtagRepository hashtagRepository, HashtagMapper hashtagMapper) {
        this.hashtagRepository = hashtagRepository;
        this.hashtagMapper = hashtagMapper;
    }

    public List<HashtagDTO> getAllHashtags() {
        List<Hashtag> hashtags = hashtagRepository.findAll();
        return hashtags.stream()
                .map(hashtagMapper::hashtagToDTO)
                .collect(Collectors.toList());
    }

    public HashtagDTO getHashtagById(Long id) {
        Hashtag hashtag = hashtagRepository.findById(id).orElseThrow(() -> new RuntimeException("Hashtag not found"));
        return hashtagMapper.hashtagToDTO(hashtag);
    }

    public HashtagDTO createHashtag(String name) {
        // Check if the hashtag already exists
        Hashtag existingHashtag = hashtagRepository.findByName(name);
        if (existingHashtag != null) {
            throw new RuntimeException("Hashtag already exists");
        }

        // Create a new hashtag
        Hashtag newHashtag = new Hashtag(name);
        Hashtag savedHashtag = hashtagRepository.save(newHashtag);
        
        // Map the saved hashtag to DTO and return
        return hashtagMapper.hashtagToDTO(savedHashtag);
    }
}
