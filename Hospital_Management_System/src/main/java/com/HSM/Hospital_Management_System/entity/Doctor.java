package com.HSM.Hospital_Management_System.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Doctor {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Doctor_id;
    private String First_name;
    private String Last_name;
    private String Mobile_number;
    private String Doc_address;
    private String Email;
    private String Department;
}
