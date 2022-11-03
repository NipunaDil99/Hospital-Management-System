package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.BedType;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.BedTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BedTypeService {
    @Autowired
    private BedTypeRepo bedTypeRepo;

    public BedType addBedType(BedType bedType){
        return bedTypeRepo.save(bedType);
    }

    public List<BedType> getAllBedTypes(){
        return bedTypeRepo.findAll();
    }

    public ResponseEntity<BedType> updateBedType(int id, BedType bedTypeDetails){
        BedType updateBedType = bedTypeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bed Type does not exists with this id: "+id));

        updateBedType.setType_Name(bedTypeDetails.getType_Name());
        updateBedType.setDescription(bedTypeDetails.getDescription());
        updateBedType.setStatus(bedTypeDetails.getStatus());

        bedTypeRepo.save(updateBedType);
        return ResponseEntity.ok(updateBedType);
    }

    public ResponseEntity<HttpStatus> deleteBedType(int id){
        BedType bedType = bedTypeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bed Type does not exists with this id: "+id));
        bedTypeRepo.delete(bedType);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
