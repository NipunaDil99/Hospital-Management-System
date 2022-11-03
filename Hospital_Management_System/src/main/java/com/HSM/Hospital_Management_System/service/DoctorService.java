package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Doctor;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor addDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
    }


    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }


    public ResponseEntity<Doctor> updateDoctor(int id, Doctor doctorDetails){
        Doctor updatedoctor = doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not exists with this id: "+id));

        updatedoctor.setDoctor_id(doctorDetails.getDoctor_id());
        updatedoctor.setEmail(doctorDetails.getEmail());
        updatedoctor.setDepartment(doctorDetails.getDepartment());
        updatedoctor.setFirst_name(doctorDetails.getFirst_name());
        updatedoctor.setLast_name(doctorDetails.getLast_name());
        updatedoctor.setMobile_number(doctorDetails.getMobile_number());
        updatedoctor.setDoc_address(doctorDetails.getDoc_address());

        doctorRepo.save(updatedoctor);
        return ResponseEntity.ok(updatedoctor);
    }

    public ResponseEntity<HttpStatus> deleteDoctor(int id){
        Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not exists with this id: "+id));
        doctorRepo.delete(doctor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Doctor> getDoctorById(int id){
        Doctor doctor = doctorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Doctor not exist with id :"+ id));
        return ResponseEntity.ok(doctor);
    }
}


