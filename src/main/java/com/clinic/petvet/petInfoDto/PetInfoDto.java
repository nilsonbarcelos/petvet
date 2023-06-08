package com.clinic.petvet.petInfoDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetInfoDto(

        @NotBlank
        String dogName,

        @NotNull
        Integer dogAge,

        @NotBlank
        String dogBreed,

        @NotBlank
        String tutorName,

        @NotBlank
        String tutorPhone,

        @Email
        String tutorEmail,

        @NotNull
        @Valid
        TutorAddressDto tutorAddress
) {
}
