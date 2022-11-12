package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.Appointment;
import com.HSM.Hospital_Management_System.exception.ResourceNotFoundException;
import com.HSM.Hospital_Management_System.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public Appointment saveAppointment(Appointment appointment){
        appointment.setDate(new Date());
        return repository.save(appointment);
    }

    public ResponseEntity<Appointment> updateAppointment(int id, Appointment appointment){
        Appointment oldAppointment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There is no appointment with the id :"+id));

        oldAppointment.setDate(new Date());
        oldAppointment.setStatus(appointment.getStatus());
        oldAppointment.setProblem(appointment.getProblem());

        repository.save(oldAppointment);
        return ResponseEntity.ok(oldAppointment);
    }

  
    public ResponseEntity<HttpStatus> deleteAppointment(int id){
        Appointment appointment = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no appointment with the id :"+id));
        repository.delete(appointment);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public List<Appointment> getAllAppointments(){
        return repository.findAll();
    }

    public ResponseEntity<Appointment> getAppointmentById(int id){
        Appointment appointment = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("There is no appointment with the id :"+ id));
        return ResponseEntity.ok(appointment);
    }
}