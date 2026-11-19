package org.hotl.libraryjpatesting.api.mappers;


import org.hotl.libraryjpatesting.api.dtos.json.JsonUserRequestDto;
import org.hotl.libraryjpatesting.api.dtos.json.JsonUserResponseDto;
import org.hotl.libraryjpatesting.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserEntityMapper {

    UserEntity toJsonUser(JsonUserRequestDto jsonUserRequestDto);

    List<UserEntity> toUserEntities(List<JsonUserRequestDto> jsonUsersRequestDto);

    List<JsonUserResponseDto> toJsonUsersResponseDto(List<UserEntity> usersEntity);

    JsonUserResponseDto toJsonUser(UserEntity userEntity);



}
