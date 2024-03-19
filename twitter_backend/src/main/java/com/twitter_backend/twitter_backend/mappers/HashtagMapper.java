package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.HashtagDTO;
import com.twitter_backend.twitter_backend.models.Hashtag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HashtagMapper {

    HashtagMapper INSTANCE = Mappers.getMapper(HashtagMapper.class);

    @Mapping(target = "id", ignore = true)
    Hashtag toEntity(HashtagDTO hashtagDTO);
    
    @Mapping(target = "id", source = "hashtag.id")
    @Mapping(target = "name", source = "hashtag.name")
    HashtagDTO hashtagToDTO(Hashtag hashtag);

    @Mapping(target = "id", source = "hashtagDTO.id")
    @Mapping(target = "name", source = "hashtagDTO.name")
    Hashtag dtoToHashtag(HashtagDTO hashtagDTO);

    
}
