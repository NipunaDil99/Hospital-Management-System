package com.HSM.Hospital_Management_System.controller;

import com.HSM.Hospital_Management_System.entity.Appointment;
import com.HSM.Hospital_Management_System.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/appointment/")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping("/saveAppointment")
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return service.saveAppointment(appointment);
    }

    @PutMapping("/updateAppointment/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment){
        return service.updateAppointment(id,appointment);
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable int id){
        return service.deleteAppointment(id);
    }

    @GetMapping("/getAppointments")
    public List<Appointment> getAllAppointments(){
        return service.getAllAppointments();
    }

    @GetMapping("/getAppointment/{id}")
    public Appointment getAppointmentById(@PathVariable int id){
        return service.getAppointmentById(id);
    }
}
