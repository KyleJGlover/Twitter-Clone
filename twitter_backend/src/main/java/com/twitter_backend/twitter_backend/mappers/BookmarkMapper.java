package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.BookmarkDTO;
import com.twitter_backend.twitter_backend.models.Bookmark;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookmarkMapper {

    BookmarkMapper INSTANCE = Mappers.getMapper(BookmarkMapper.class);

    @Mapping(target = "id", ignore = true)
    Bookmark toEntity(BookmarkDTO bookmarkDTO);

    BookmarkDTO toDTO(Bookmark bookmark);
}
