package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Patient;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient addPatient(Patient patient){
        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public ResponseEntity<Patient> updatePatient(int id, Patient patientDetails){
        Patient updatePatient = patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not exists with this id: "+id));

        updatePatient.setFirst_name(patientDetails.getFirst_name());
        updatePatient.setLast_name(patientDetails.getLast_name());
        updatePatient.setGender(patientDetails.getGender());
        updatePatient.setBlood_group(patientDetails.getBlood_group());
        updatePatient.setMobile_number(patientDetails.getMobile_number());
        updatePatient.setAddress(patientDetails.getAddress());
        updatePatient.setDob(patientDetails.getDob());
        updatePatient.setStatus(patientDetails.getStatus());


        patientRepo.save(updatePatient);
        return ResponseEntity.ok(updatePatient);
    }

    public ResponseEntity<HttpStatus> deletePatient(int id){
        Patient patient = patientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not exists with this id: "+id));
        patientRepo.delete(patient);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Patient> getPatientById(int id){
        Patient patient = patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient not exist with id :"+ id));
        return ResponseEntity.ok(patient);
    }

}
