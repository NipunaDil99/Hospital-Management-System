package com.HSM.Hospital_Management_System.repo;

import com.HSM.Hospital_Management_System.entity.PatientDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientDocumentsRepository extends JpaRepository<PatientDocuments, Integer> {
}
