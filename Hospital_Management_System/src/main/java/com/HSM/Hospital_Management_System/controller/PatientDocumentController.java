//package com.HSM.Hospital_Management_System.controller;
//
//import com.HSM.Hospital_Management_System.entity.PatientDocuments;
//import com.HSM.Hospital_Management_System.service.PatientDocumentsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "api/v1/patient")
//@CrossOrigin
//public class PatientDocumentController {
//
//    @Autowired
//    private PatientDocumentsService patientDocumentsService;
//
//    @PostMapping("/upload")
//    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
//        Attachment attachment = null;
//        String downloadURl = "";
//        attachment = attachmentService.saveAttachment(file);
//        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path(attachment.getId())
//                .toUriString();
//
//        return new ResponseData(attachment.getFileName(),
//                downloadURl,
//                file.getContentType(),
//                file.getSize());
//    }
//
////    @PostMapping("/patientDocuments/addPatientDocument")
////    public PatientDocuments addPatientDocument(@RequestBody PatientDocuments patientDocument) {
////        return patientDocumentsService.savePatientDocument(patientDocument);
////    }
////
////    @PostMapping("/patientDocuments/addPatientDocument")
////    public ResponseEntity<?> addPatientDocument(@RequestBody PatientDocuments patientDocument) throws IOException {
////        String uploadFile = patientDocumentsService.savePatientDocument(patientDocument);
////        return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
////    }
//
////    @PostMapping("/patientDocuments/addPatientDocuments")
////    public List<PatientDocuments> addPatientDocuments(@RequestBody List<PatientDocuments> patientDocuments) {
////        return patientDocumentsService.savePatientDocuments(patientDocuments);
////    }
////
////    @GetMapping("/patientDocuments/getPatientDocumentById/{id}")
////    public PatientDocuments getPatientDocumentById(@PathVariable int id) {
////        return patientDocumentsService.getPatientDocumentById(id);
////    }
////
////    @GetMapping("/patientDocuments/getPatientDocuments")
////    public List<PatientDocuments> getPatientDocuments() {
////        return patientDocumentsService.getPatientDocuments();
////    }
////
////    @PutMapping("/patientDocuments/updatePatientDocument")
////    public PatientDocuments updatePatientDocumentById(@RequestBody PatientDocuments patientDocument) {
////        return patientDocumentsService.updatePatientDocumentById(patientDocument);
////    }
////
////    @DeleteMapping("/patientDocuments/deletePatientDocumentById/{id}")
////    public String deletePatientDocumentById(@PathVariable int id) {
////        return patientDocumentsService.deletePatientDocumentById(id);
////    }
//
//
//}
