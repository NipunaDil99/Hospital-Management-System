package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.PatientCaseStudy;
import com.HSM.Hospital_Management_System.repo.PatientCaseStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCaseStudyService {

    @Autowired
    private PatientCaseStudyRepository patientCaseStudyRepository;

    public PatientCaseStudy savePatientCaseStudy(PatientCaseStudy patientCaseStudy) {
        return patientCaseStudyRepository.save(patientCaseStudy);
    }

    public List<PatientCaseStudy> savePatientCaseStudies(List<PatientCaseStudy> patientCaseStudies) {
        return patientCaseStudyRepository.saveAll(patientCaseStudies);
    }

    public List<PatientCaseStudy> getPatientCaseStudies() {
        return patientCaseStudyRepository.findAll();
    }

    public PatientCaseStudy getPatientCaseStudyById(int id) {
        return patientCaseStudyRepository.findById(id).orElse(null);
    }

    public String deletePatientCaseStudyById(int id) {
        patientCaseStudyRepository.deleteById(id);
        return "Case Study Deleted " + id;
    }

    public PatientCaseStudy updatePatientCaseStudyById(PatientCaseStudy patientCaseStudy) {
        PatientCaseStudy existingPatientCaseStudy = patientCaseStudyRepository.findById(patientCaseStudy.getId()).orElse(null);
        existingPatientCaseStudy.setFoodAllergies(patientCaseStudy.getFoodAllergies());
        existingPatientCaseStudy.setOthers(patientCaseStudy.getOthers());
        existingPatientCaseStudy.setCurrentMedication(patientCaseStudy.getCurrentMedication());
        return patientCaseStudyRepository.save(existingPatientCaseStudy);
    }
}
