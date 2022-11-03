package com.HSM.Hospital_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bed {
    @Id
    private int id;
    private String Description;
    private String Assigned_date;
    private String Discharge_date;
    private String status;
}
