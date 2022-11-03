package com.HSM.Hospital_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {
    @Id
    private int patient_id;

    private String drug_name;
    private String dosage;
    private Date issued_date;
}
