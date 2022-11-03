package com.HSM.Hospital_Management_System.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "PATIENT_CASESTUDY")
public class PatientCaseStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foodAllergies;
    private boolean tendencyBleed;
    private boolean heartDisease;
    private boolean highBloodPressure;
    private boolean diabetics;
    private boolean surgery;
    private boolean accident;
    private String others;
    private String currentMedication;
}
