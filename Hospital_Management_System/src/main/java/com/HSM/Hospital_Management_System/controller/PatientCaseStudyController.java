package com.HSM.Hospital_Management_System.controller;

import com.HSM.Hospital_Management_System.entity.PatientCaseStudy;
import com.HSM.Hospital_Management_System.service.PatientCaseStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/patient")
@CrossOrigin
public class PatientCaseStudyController {
    @Autowired
    private PatientCaseStudyService patientCaseStudyService;

    @PostMapping("/patientCaseStudy/addPatientCaseStudy")
    public PatientCaseStudy addPatientCaseStudy(@RequestBody PatientCaseStudy patientCaseStudy) {
        return patientCaseStudyService.savePatientCaseStudy(patientCaseStudy);
    }

    @PostMapping("/patientCaseStudy/addPatientCaseStudies")
    public List<PatientCaseStudy> addPatientDocuments(@RequestBody List<PatientCaseStudy> patientCaseStudies) {
        return patientCaseStudyService.savePatientCaseStudies(patientCaseStudies);
    }

    @GetMapping("/patientCaseStudy/getPatientCaseStudyById/{id}")
    public PatientCaseStudy getPatientDocumentById(@PathVariable int id) {
        return patientCaseStudyService.getPatientCaseStudyById(id);
    }

    @GetMapping("/patientCaseStudy/getPatientCaseStudies")
    public List<PatientCaseStudy> getPatientCaseStudies() {
        return patientCaseStudyService.getPatientCaseStudies();
    }

    @PutMapping("/patientCaseStudy/updatePatientCaseStudy")
    public PatientCaseStudy updatePatientCaseStudyById(@RequestBody PatientCaseStudy patientCaseStudy) {
        return patientCaseStudyService.updatePatientCaseStudyById(patientCaseStudy);
    }

    @DeleteMapping("/patientCaseStudy/deletePatientCaseStudyById/{id}")
    public String deletePatientCaseStudyById(@PathVariable int id) {
        return patientCaseStudyService.deletePatientCaseStudyById(id);
    }


}