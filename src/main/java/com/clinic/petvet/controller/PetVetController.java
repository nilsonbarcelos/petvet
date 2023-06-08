package com.clinic.petvet.controller;

import com.clinic.petvet.petInfoDto.PetInfoDto;
import com.clinic.petvet.petInfoDto.PetInfoResponseDto;
import com.clinic.petvet.petInfoDto.PetUpdateDto;
import com.clinic.petvet.petInfoEntity.PetInfo;
import com.clinic.petvet.repository.PetVetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("petvet")
public class PetVetController {

    @Autowired
    PetVetRepository petVetRepository;

    @PostMapping
    @Transactional
    public void savePetInfo(@RequestBody @Valid PetInfoDto petInfoDto){
        petVetRepository.save(new PetInfo(petInfoDto));
    }

    @GetMapping
    public Page<PetInfoResponseDto> listPetInfo(@PageableDefault(size = 3, sort = {"dogName"})Pageable pagination){
        return petVetRepository.findAllByActiveTrue(pagination).map(PetInfoResponseDto::new);
    }

    @PutMapping
    @Transactional
    public void updatePetInfo(@RequestBody @Valid PetUpdateDto petUpdateDto){
        var pet = petVetRepository.getReferenceById(petUpdateDto.id());
        pet.updatePetValues(petUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removePetInfo(@PathVariable Long id){
        var pet = petVetRepository.getReferenceById(id);
        pet.removePetInfo();
    }

}
