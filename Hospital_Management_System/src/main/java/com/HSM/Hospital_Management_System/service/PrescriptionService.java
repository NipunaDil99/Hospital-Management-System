package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Prescription;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return repository.save(prescription);
    }

    public ResponseEntity<Prescription> getPrescriptionById(int id){
        Prescription prescription = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("There is no prescription with the id :"+ id));
        return ResponseEntity.ok(prescription);
    }

    public ResponseEntity<HttpStatus> deletePrescription(int id){
        Prescription prescription = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no prescription with the id :"+id));
        repository.delete(prescription);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Prescription> updatePrescription(int id, Prescription prescription){
        Prescription oldPrescription = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no prescription with the id :"+id));
       
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
