package com.HSM.Hospital_Management_System.controller;


import com.HSM.Hospital_Management_System.entity.Patient;
import com.HSM.Hospital_Management_System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/patient/")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/getPatient")
    public List<Patient> getUser(){
        return patientService.getAllPatients();
    }

    @PostMapping("/savePatient")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<Patient> updateUser(@PathVariable int id, @RequestBody Patient patientList){
        return patientService.updatePatient(id,patientList);
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id ){
        return patientService.deletePatient(id);
    }

   @GetMapping("/getPatientId/{id}")
    public ResponseEntity<Patient> getPatientById (@PathVariable int id){
        return patientService.getPatientById(id);
   }
}
