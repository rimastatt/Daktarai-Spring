package com.example.demo.repositories;

import com.example.demo.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> getAllDoctorsByRegion(String region, Pageable pageable);

    Page<Doctor> getAllDoctorsBySpec(String specialization, Pageable pageable);
}
