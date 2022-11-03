package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Bed;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.BedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BedService {
    @Autowired
    private BedRepo bedRepo;

    public Bed addBed(Bed bed){
        return bedRepo.save(bed);
    }

    public List<Bed> getAllBeds(){
        return bedRepo.findAll();
    }

    public ResponseEntity<Bed> updateBed(int id, Bed bedDetails){
        Bed updateBed = bedRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bed does not exists with this id: "+id));

        updateBed.setDescription(bedDetails.getDescription());
        updateBed.setAssigned_date(bedDetails.getAssigned_date());
        updateBed.setDischarge_date(bedDetails.getDischarge_date());
        updateBed.setStatus(bedDetails.getStatus());

        bedRepo.save(updateBed);
        return ResponseEntity.ok(updateBed);
    }

    public ResponseEntity<HttpStatus> deleteBed(int id){
        Bed bed = bedRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bed does not exists with this id: "+id));
        bedRepo.delete(bed);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Bed> getBedById(int id){
        Bed bed = bedRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Bed does not exist with id :"+ id));
        return ResponseEntity.ok(bed);
    }

}
