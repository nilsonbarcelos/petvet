package com.clinic.petvet.petInfoEntity;

import com.clinic.petvet.petInfoDto.TutorAddressDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TutorAddress {

    private String address;
    private String neighborhood;
    private String zipCode;
    private Integer addressNumber;
    private String complement;
    private String city;
    private String state;
    private String country;


    public TutorAddress(TutorAddressDto tutorAddressDto) {
        this.address = tutorAddressDto.address();
        this.neighborhood = tutorAddressDto.neighborhood();
        this.zipCode = tutorAddressDto.zipCode();
        this.addressNumber = tutorAddressDto.addressNumber();
        this.complement = tutorAddressDto.complement();
        this.city = tutorAddressDto.city();
        this.state = tutorAddressDto.state();
        this.country = tutorAddressDto.country();
    }
}
