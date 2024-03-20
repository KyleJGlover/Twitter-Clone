package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.BookmarkDTO;
import com.twitter_backend.twitter_backend.models.Bookmark;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BookmarkMapper {

    @Mapping(target = "id", ignore = true)
    Bookmark toEntity(BookmarkDTO bookmarkDTO);

    BookmarkDTO toDTO(Bookmark bookmark);

    List<Bookmark> toEntityList(List<BookmarkDTO> bookmarkDTOs);
    List<BookmarkDTO> toDTOList(List<Bookmark> bookmarks);
}
