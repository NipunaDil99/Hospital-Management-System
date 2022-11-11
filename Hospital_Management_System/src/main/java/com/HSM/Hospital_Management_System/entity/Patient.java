package com.HSM.Hospital_Management_System.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Patient {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private String blood_group;
    private String mobile_number;
    private String address;
    private Date DOB;
    private String status;

}