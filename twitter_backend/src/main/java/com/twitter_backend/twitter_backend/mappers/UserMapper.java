package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.UserDTO;
import com.twitter_backend.twitter_backend.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
}
