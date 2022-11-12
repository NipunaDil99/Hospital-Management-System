package com.HSM.Hospital_Management_System.controller;

import com.HSM.Hospital_Management_System.entity.Prescription;
import com.HSM.Hospital_Management_System.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/prescription/")
@CrossOrigin
public class PrescriptionController {
    @Autowired
    private PrescriptionService service;

    @PostMapping("/addPrescription")
    public Prescription addPrescription(@RequestBody Prescription prescription){
        return service.addPrescription(prescription);
    }

    @GetMapping("/getPrescription/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable int id){
        return service.getPrescriptionById(id);
    }

    @DeleteMapping("/deletePrescription/{id}")
    public ResponseEntity<HttpStatus> deletePrescription(@PathVariable int id){
        return service.deletePrescription(id);
    }

    @PutMapping("/updatePrescription/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable int id, @RequestBody Prescription prescription){
        return service.updatePrescription(id,prescription);
    }

    @GetMapping("/getPrescriptions")
    public List<Prescription> getPrescriptions(){
        return service.getAllPrescriptions();
    }
}
