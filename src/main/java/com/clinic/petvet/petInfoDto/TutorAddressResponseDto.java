package com.clinic.petvet.petInfoDto;

import com.clinic.petvet.petInfoEntity.TutorAddress;

public record TutorAddressResponseDto(
        String address,
        String neighborhood,
        String zipCode,
        Integer addressNumber,
        String complement,
        String city,
        String state,
        String country
) {
    public TutorAddressResponseDto(TutorAddress tutorAddress){
        this(tutorAddress.getAddress(), tutorAddress.getNeighborhood(),
                tutorAddress.getZipCode(), tutorAddress.getAddressNumber(),
                tutorAddress.getComplement(), tutorAddress.getCity(),
                tutorAddress.getState(), tutorAddress.getCountry());
    }

}
