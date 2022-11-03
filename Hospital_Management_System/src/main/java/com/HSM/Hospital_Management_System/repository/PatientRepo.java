package com.HSM.Hospital_Management_System.repository;

import com.HSM.Hospital_Management_System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Integer> {
}