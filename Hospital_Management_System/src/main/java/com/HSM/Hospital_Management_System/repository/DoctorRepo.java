package com.HSM.Hospital_Management_System.repository;

import com.HSM.Hospital_Management_System.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
