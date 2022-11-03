package com.HSM.Hospital_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BedType {
    @Id
    private int id;
    private String Type_Name;
    private String Description;
    private String status;
}
