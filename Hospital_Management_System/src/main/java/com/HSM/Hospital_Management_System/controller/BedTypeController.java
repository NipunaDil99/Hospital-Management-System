package com.HSM.Hospital_Management_System.controller;


import com.HSM.Hospital_Management_System.entity.BedType;
import com.HSM.Hospital_Management_System.service.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/bedType/")
@CrossOrigin
public class BedTypeController {
    @Autowired
    private BedTypeService bedTypeService;

    @GetMapping("/getBedType")
    public List<BedType> getBedType(){
        return bedTypeService.getAllBedTypes();
    }

    @PostMapping("/saveBedType")
    public BedType saveBedType(@RequestBody BedType bedType){
        return bedTypeService.addBedType(bedType);
    }

    @PutMapping("/updateBedType/{id}")
    public ResponseEntity<BedType> updateUser(@PathVariable int id, @RequestBody BedType bedTypeList){
        return bedTypeService.updateBedType(id,bedTypeList);
    }

    @DeleteMapping("/deleteBedType/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id ){
        return bedTypeService.deleteBedType(id);
    }

}
