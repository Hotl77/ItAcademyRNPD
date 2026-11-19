package org.hotl.libraryjpatesting.api.dtos.json;

import java.util.List;

public record JsonUsersResponseDto(
        List<JsonUserResponseDto> usersResponse
) {
}
