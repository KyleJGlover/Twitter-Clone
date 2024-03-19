package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.LikeDTO;
import com.twitter_backend.twitter_backend.models.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(target = "id", ignore = true)
    Like toEntity(LikeDTO likeDTO);

    LikeDTO toDTO(Like like);
}
