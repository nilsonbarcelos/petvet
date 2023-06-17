package com.clinic.petvet.controller;

import com.clinic.petvet.petInfoDto.PetInfoDto;
import com.clinic.petvet.petInfoDto.PetInfoResponseDto;
import com.clinic.petvet.petInfoDto.PetUpdateDto;
import com.clinic.petvet.petInfoDto.PetUpdateResponse;
import com.clinic.petvet.petInfoEntity.PetInfo;
import com.clinic.petvet.repository.PetVetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("petvet")
public class PetVetController {

    @Autowired
    PetVetRepository petVetRepository;

    @PostMapping
    @Transactional
    public ResponseEntity savePetInfo(@RequestBody @Valid PetInfoDto petInfoDto, UriComponentsBuilder uriBuilder){
        var petInfo = new PetInfo(petInfoDto);
        petVetRepository.save(petInfo);

        var uri = uriBuilder.path("/petvet/{id}").buildAndExpand(petInfo.getId()).toUri();
        return ResponseEntity.created(uri).body(new PetUpdateResponse(petInfo));
    }

    @GetMapping
    public ResponseEntity<Page<PetInfoResponseDto>> listPetInfo(@PageableDefault(size = 3, sort = {"dogName"})Pageable pagination){
        var page = petVetRepository.findAllByActiveTrue(pagination).map(PetInfoResponseDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePetInfo(@RequestBody @Valid PetUpdateDto petUpdateDto){
        var pet = petVetRepository.getReferenceById(petUpdateDto.id());
        pet.updatePetValues(petUpdateDto);
        return ResponseEntity.ok(new PetUpdateResponse(pet));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removePetInfo(@PathVariable Long id){
        var pet = petVetRepository.getReferenceById(id);
        pet.removePetInfo();
        return ResponseEntity.noContent().build();
    }

}
