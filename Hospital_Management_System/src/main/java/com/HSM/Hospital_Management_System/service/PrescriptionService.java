package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Prescription;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepo repository;

    public Prescription addPrescription(Prescription prescription){
        prescription.setIssued_date(new Date());
        repository.save(prescription);
        return prescription;
    }

    public Prescription getPrescriptionById(int id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no prescription with the id"));
    }

    public String deletePrescription(int id){
        repository.deleteById(id);
        return "Prescription successfully deleted";
    }

    public ResponseEntity<Prescription> updatePrescription(int id, Prescription prescription){
        Prescription oldPrescription = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no prescription with the id"));
        oldPrescription.setDrug_name(prescription.getDrug_name());
        oldPrescription.setDosage(prescription.getDosage());
        oldPrescription.setIssued_date(new Date());

        repository.save(oldPrescription);
        return ResponseEntity.ok(oldPrescription);
    }

    public List<Prescription> getAllPrescriptions(){
        return repository.findAll();
    }
}
