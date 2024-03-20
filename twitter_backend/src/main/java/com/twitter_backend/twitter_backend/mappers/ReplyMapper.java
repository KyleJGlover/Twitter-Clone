package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.ReplyDTO;
import com.twitter_backend.twitter_backend.models.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ReplyMapper {

    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    @Mapping(target = "id", ignore = true)
    Reply toEntity(ReplyDTO replyDTO);

    ReplyDTO toDTO(Reply reply);
}
