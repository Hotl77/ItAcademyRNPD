package org.hotl.libraryjpatesting.api.dtos.json;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record JsonUserResponseDto(

        String userId,

        @Size(max = 50)
        String firstName,

        @Size(max = 50)
        String lastName,

        @Size(max = 50)
        String middleName,

        @NotBlank()
        @Email()
        @Size(max = 100)
        String email,

        @NotBlank()
        @Pattern(regexp = "^7[0-9]{10}$")
        String phoneNumber,

        @Pattern(regexp = "^[0-9]+$")
        String libraryCardNumber,

        @NotBlank()
        @Pattern(regexp = "^\\d{4} \\d{6}$")
        String passportSeriesAndNumber

) {
}
