package com.clinic.petvet.petInfoDto;

import com.clinic.petvet.petInfoEntity.PetInfo;


public record PetInfoResponseDto(Long id,
                                 String dogName,
                                 Integer dogAge,
                                 String dogBreed,
                                 String tutorName,
                                 String tutorPhone,
                                 String tutorEmail,
                                 TutorAddressResponseDto tutorAddress) {
    public PetInfoResponseDto(PetInfo petInfo){
        this(petInfo.getId(), petInfo.getDogName(), petInfo.getDogAge(), petInfo.getDogBreed(), petInfo.getTutorName(),
                petInfo.getTutorPhone(), petInfo.getTutorEmail(), new TutorAddressResponseDto(petInfo.getTutorAddress()));
    }
}
