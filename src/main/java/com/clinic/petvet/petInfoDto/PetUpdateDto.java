package com.clinic.petvet.petInfoDto;

import jakarta.validation.constraints.NotNull;

public record PetUpdateDto(
        @NotNull
        Long id,

        String dogName,
        Integer dogAge,
        String dogBreed,
        String tutorName,
        String tutorPhone,
        String tutorEmail,
        TutorAddressDto tutorAddress
) {
}
