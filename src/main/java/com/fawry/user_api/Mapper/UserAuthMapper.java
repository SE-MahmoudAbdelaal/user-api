package com.fawry.user_api.Mapper;

import com.fawry.user_api.entity.User;
import com.fawry.user_api.model.AuthenticationResponse;
import com.fawry.user_api.model.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {
    User toEntity(RegisterRequest dto);
    AuthenticationResponse toDTO(String token);
}
