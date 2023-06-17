package com.clinic.petvet.petInfoDto;

import com.clinic.petvet.petInfoEntity.PetInfo;
import com.clinic.petvet.petInfoEntity.TutorAddress;

public record PetUpdateResponse(
        Long id,
        String dogName,
        Integer dogAge,
        String dogBreed,
        String tutorName,
        String tutorPhone,
        String tutorEmail,
        TutorAddress tutorAddress
) {
    public PetUpdateResponse(PetInfo pet){
        this(pet.getId(), pet.getDogName(), pet.getDogAge(), pet.getDogBreed(),
                pet.getTutorName(), pet.getTutorPhone(), pet.getTutorEmail(), pet.getTutorAddress());
    }
}
