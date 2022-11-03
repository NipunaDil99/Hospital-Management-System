package com.HSM.Hospital_Management_System.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private int appointment_id;
    private Date date;
    private String problem;
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Patient patient;
}
