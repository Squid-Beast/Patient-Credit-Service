package com.example.patientspringproject.service;

import com.example.patientspringproject.entity.Patient;
import com.example.patientspringproject.pojo.PatientDetails;
import com.example.patientspringproject.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientDetails getPatientDetailsById(Long id){
        Patient patientById = patientRepository.findById(id).orElse(null);
        if (patientById == null){
            throw new RuntimeException("No Patient Details Found.");
        }
        PatientDetails patientDetails= new PatientDetails();
        BeanUtils.copyProperties(patientById,patientDetails);
        return patientDetails;
    }

    public PatientDetails createPatientDetails(PatientDetails patientDetails){
        Patient patient=new Patient();
        BeanUtils.copyProperties(patientDetails, patient);

        patient = patientRepository.save(patient);
        BeanUtils.copyProperties(patient, patientDetails);
        return patientDetails;
    }
}
