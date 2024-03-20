package com.twitter_backend.twitter_backend.mappers;

import com.twitter_backend.twitter_backend.dto.UserDTO;
import com.twitter_backend.twitter_backend.models.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
}
