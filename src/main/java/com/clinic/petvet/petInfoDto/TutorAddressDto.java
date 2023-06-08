package com.clinic.petvet.petInfoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TutorAddressDto(
        @NotBlank
        String address,

        @NotBlank
        String neighborhood,

        @NotBlank
        String zipCode,

        @NotNull
        Integer addressNumber,

        String complement,

        @NotBlank
        String city,

        @NotBlank
        String state,

        @NotBlank
        String country
) {
}
