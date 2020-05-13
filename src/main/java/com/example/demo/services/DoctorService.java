package com.example.demo.services;

import com.example.demo.entities.Doctor;
import com.example.demo.exceptions.DoctorNotFoundException;
import com.example.demo.repositories.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("This doctor with ID: " + id + "was fired!"));
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }

    public Doctor submitOrUpdateDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Page<Doctor> getAllDoctorsPaginated(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 2);
        return doctorRepository.findAll(pageable);
    }

    public List<Doctor> getDoctorsByRegion(String region, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 1);
        return doctorRepository.getAllDoctorsByRegion(region, pageable).getContent();
    }

    public List<Doctor> getDoctorsBySpec(String spec, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 1);
        return doctorRepository.getAllDoctorsBySpec(spec, pageable).getContent();
    }
}
