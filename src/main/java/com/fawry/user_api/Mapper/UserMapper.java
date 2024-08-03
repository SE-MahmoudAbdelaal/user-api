package com.fawry.user_api.Mapper;


import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.UserRegistrationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
    public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        User toEntity(UserRegistrationDTO dto);
        UserRegistrationDTO toDTO(User entity);
    }
