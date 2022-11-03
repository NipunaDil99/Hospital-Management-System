package com.HSM.Hospital_Management_System.service;

import com.HSM.Hospital_Management_System.entity.PatientDocuments;
import com.HSM.Hospital_Management_System.repo.PatientDocumentsRepository;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PatientDocumentsService {

    @Autowired
    private PatientDocumentsRepository patientDocumentsRepository;

    public PatientDocuments savePatientDocument(MultipartFile patientDocument) throws Exception {
        String fileName = StringUtils.cleanPath(patientDocument.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            PatientDocuments patientDocuments
                    = new PatientDocuments(fileName,
                    patientDocument.getContentType(),
                    patientDocument.getBytes());
            return patientDocumentsRepository.save(patientDocuments);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

//    public PatientDocuments getPatientDocument(MultipartFile patientDocument) throws Exception {
//        return patientDocumentsRepository.findById(patientDocument.getName());
//    }
//    public String savePatientDocument(MultipartFile patientDocument) throws IOException {
//        PatientDocuments document = patientDocumentsRepository.save(PatientDocuments.builder()
//                .description(patientDocument.getDescription())
//                .type(patientDocument.getType())
//                .imageData(DocumentUtils.compressImage(patientDocument.getBytes())).build());
//
//        if (document != null) {
//            return "File uploaded successfully: " + patientDocument.getId();
//
//        }
//        return null;
//    }
//
//    public List<PatientDocuments> savePatientDocuments(List<PatientDocuments> patientDocuments) {
//        return patientDocumentsRepository.saveAll(patientDocuments);
//    }
//
//    public List<PatientDocuments> getPatientDocuments() {
//        return patientDocumentsRepository.findAll();
//    }
//
//    public PatientDocuments getPatientDocumentById(int id) {
//        return patientDocumentsRepository.findById(id).orElse(null);
//    }
//
//    public String deletePatientDocumentById(int id) {
//        patientDocumentsRepository.deleteById(id);
//        return "Document Deleted " + id;
//    }
//
//    public PatientDocuments updatePatientDocumentById(PatientDocuments patientDocument) {
//        PatientDocuments existingDocument = patientDocumentsRepository.findById(patientDocument.getId()).orElse(null);
//        existingDocument.setDescription(patientDocument.getDescription());
//        existingDocument.setType(patientDocument.getType());
//        existingDocument.setImageData(patientDocument.getImageData());
//        return patientDocumentsRepository.save(existingDocument);
//    }

//    public String uploadImage(MultipartFile file) throws IOException {
//
//        PatientDocuments patientDocuments = patientDocumentsRepository.save(PatientDocuments.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(file.getBytes())).build());
//        if ( != null) {
//            return "file uploaded successfully : " + file.getOriginalFilename();
//        }
//        return null;
//    }
//
//    public byte[] downloadImage(String fileName){
//        Optional<ImageData> dbImageData = repository.findByName(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
//        return images;
//    }
}
