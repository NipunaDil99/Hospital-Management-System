package com.HSM.Hospital_Management_System.controller;


import com.HSM.Hospital_Management_System.entity.Bed;
import com.HSM.Hospital_Management_System.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/bed/")
@CrossOrigin
public class BedController {
    @Autowired
    private BedService bedService;

    @GetMapping("/getBed")
    public List<Bed> getBed(){
        return bedService.getAllBeds();
    }

    @PostMapping("/saveBed")
    public Bed saveBed(@RequestBody Bed bed){
        return bedService.addBed(bed);
    }

    @PutMapping("/updateBed/{id}")
    public ResponseEntity<Bed> updateUser(@PathVariable int id, @RequestBody Bed bedList){
        return bedService.updateBed(id,bedList);
    }

    @DeleteMapping("/deleteBed/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id ){
        return bedService.deleteBed(id);
    }

    @GetMapping("/getBedId/{id}")
    public ResponseEntity<Bed> getBedById (@PathVariable int id){
        return bedService.getBedById(id);
    }
}
