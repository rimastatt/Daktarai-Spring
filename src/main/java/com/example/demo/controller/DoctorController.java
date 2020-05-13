package com.example.demo.controller;

import com.example.demo.entities.Doctor;
import com.example.demo.services.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctor(id);
        model.addAttribute("doctor", doctor);
        return "doctorpage";
    }

    @GetMapping
    public String getAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }

    @GetMapping("/doctor")
    public String addANewDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctorform";
    }

    @GetMapping("/doctor/{id}")
    public String getDoctorToUpdate(@PathVariable Long id, Model model){
        Doctor doctor = doctorService.getDoctor(id);
        model.addAttribute("doctor", doctor);
        return "doctorform";
    }

    @PostMapping("/doctor")
    public String submitDoctor(@ModelAttribute Doctor doctor, Model model){
        Doctor newDoctor = doctorService.submitOrUpdateDoctor(doctor);
        model.addAttribute("doctor", newDoctor);
        return "doctorpage";
    }

    @GetMapping("/doctor/{id}/delete")
    public String fireDoctor(@PathVariable Long id, Model model){
        doctorService.deleteDoctor(id);
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }

    @GetMapping("/byRegion")
    public String getDoctorsByRegion(@RequestParam String region, @RequestParam int pageNumber, Model model){
        List<Doctor> doctors = doctorService.getDoctorsByRegion(region, pageNumber);
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }

    @GetMapping("/bySpec")
    public String getDoctorsBySpec(@RequestParam String spec, @RequestParam int pageNumber, Model model){
        List<Doctor> doctors = doctorService.getDoctorsByRegion(spec, pageNumber);
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }

    @GetMapping("/paginated")
    public String getDoctorsByPage(@RequestParam(defaultValue = "0") int pageNumber, Model model) {
        Page<Doctor> doctors = doctorService.getAllDoctorsPaginated(pageNumber);
        model.addAttribute("doctors", doctors.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("hasNextPage", doctors.hasNext());
        return "doctorlistpaginated";
    }
}
