package com.HSM.Hospital_Management_System.repository;

import com.HSM.Hospital_Management_System.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepo extends JpaRepository<Bed, Integer> {
}