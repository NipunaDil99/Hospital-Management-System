package com.HSM.Hospital_Management_System.repository;

import com.HSM.Hospital_Management_System.entity.BedType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedTypeRepo extends JpaRepository<BedType, Integer> {
}