package com.clinic.petvet.petInfoEntity;

import com.clinic.petvet.petInfoDto.PetInfoDto;
import com.clinic.petvet.petInfoDto.PetUpdateDto;
import com.clinic.petvet.petInfoDto.TutorAddressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pet_vet")
@Entity(name = "petInfo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PetInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dogName;
    private Integer dogAge;
    private String dogBreed;
    private String tutorName;
    private String tutorPhone;
    private String tutorEmail;
    private Boolean active;

    @Embedded
    private TutorAddress tutorAddress;

    public PetInfo(PetInfoDto petInfoDto){

        this.active = true;
        this.dogName = petInfoDto.dogName();
        this.dogAge = petInfoDto.dogAge();
        this.dogBreed = petInfoDto.dogBreed();
        this.tutorName = petInfoDto.tutorName();
        this.tutorPhone = petInfoDto.tutorPhone();
        this.tutorEmail = petInfoDto.tutorEmail();
        this.tutorAddress = new TutorAddress(petInfoDto.tutorAddress());
    }

    public void updatePetValues(PetUpdateDto petUpdateDto) {
        if(petUpdateDto.dogName() != null){
            this.dogName = petUpdateDto.dogName();
        }
        if(petUpdateDto.dogAge() != null){
            this.dogAge = petUpdateDto.dogAge();
        }
        if(petUpdateDto.dogBreed() != null){
            this.dogBreed = petUpdateDto.dogBreed();
        }
        if(petUpdateDto.tutorName() != null){
            this.tutorName = petUpdateDto.tutorName();
        }
        if(petUpdateDto.tutorPhone() != null){
            this.tutorPhone = petUpdateDto.tutorPhone();
        }
        if(petUpdateDto.tutorEmail() != null){
            this.tutorEmail = petUpdateDto.tutorEmail();
        }
        if(petUpdateDto.tutorAddress() != null){
            this.tutorAddress = new TutorAddress(petUpdateDto.tutorAddress());
        }
    }

    public void removePetInfo() {
        this.active = false;
    }
}
