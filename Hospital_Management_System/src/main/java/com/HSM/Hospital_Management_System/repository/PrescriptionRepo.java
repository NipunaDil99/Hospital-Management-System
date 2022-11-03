package com.HSM.Hospital_Management_System.repository;

import com.HSM.Hospital_Management_System.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepo extends JpaRepository<Prescription,Integer> {
}
