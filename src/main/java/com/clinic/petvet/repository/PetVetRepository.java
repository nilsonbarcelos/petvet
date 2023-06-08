package com.clinic.petvet.repository;

import com.clinic.petvet.petInfoEntity.PetInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;


public interface PetVetRepository extends JpaRepository<PetInfo, Long> {
    Page<PetInfo> findAllByActiveTrue(Pageable pagination);
}
