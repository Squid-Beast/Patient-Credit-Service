package com.example.patientspringproject.controller;

import com.example.patientspringproject.pojo.PatientDetails;
import com.example.patientspringproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping("/patient/{id}")
    public PatientDetails getPatientDetailsById(@PathVariable("id") Long patientId){
        return patientService.getPatientDetailsById(patientId);
    }

    @PostMapping("/patient")
    public ResponseEntity<PatientDetails> createPatientDetails(@RequestBody PatientDetails patientDetails){
        patientService.createPatientDetails(patientDetails);
        return new ResponseEntity<>(patientDetails,HttpStatus.CREATED);
    }

}
