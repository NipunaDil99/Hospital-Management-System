package com.HSM.Hospital_Management_System.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "PATIENT_DOCUMENTS")
public class PatientDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;
    private String fileType;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    public PatientDocuments(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }


}
