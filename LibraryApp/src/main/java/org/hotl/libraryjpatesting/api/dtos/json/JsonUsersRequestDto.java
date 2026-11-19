package org.hotl.libraryjpatesting.api.dtos.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record JsonUsersRequestDto(
        @JsonProperty("users") List<JsonUserRequestDto> users
) {

}


