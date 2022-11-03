package com.HSM.Hospital_Management_System.controller;

import com.HSM.Hospital_Management_System.entity.Doctor;
import com.HSM.Hospital_Management_System.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/doctor/")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/getDoctor")
    public List<Doctor> getUser(){
        return doctorService.getAllDoctors();
    }
    @PostMapping("/saveDoctor")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<Doctor> updateUser(@PathVariable int id, @RequestBody Doctor doctorList){
        return doctorService.updateDoctor(id,doctorList);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id ){
        return doctorService.deleteDoctor(id);
    }

    @GetMapping("/getDoctorId/{id}")
    public ResponseEntity<Doctor> getDoctorById (@PathVariable int id){
        return doctorService.getDoctorById(id);
    }

}
