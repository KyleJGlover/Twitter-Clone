package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.TweetDTO;
import com.twitter_backend.twitter_backend.models.Tweet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface TweetMapper {

    @Mapping(target = "id", ignore = true) // Ignore mapping id during conversion
    Tweet toEntity(TweetDTO tweetDTO);

    TweetDTO toDTO(Tweet tweet);
}
