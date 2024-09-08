package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients() {
        logger.info("Fetching all patients");
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        logger.info("Fetching patient with id: {}", id);
        return patientRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        logger.info("Creating new patient: {}", patient);
        return patientRepository.save(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        logger.info("Deleting patient with id: {}", id);
        patientRepository.deleteById(id);
    }

    @GetMapping("/test")
    public String test() {
        logger.info("Test endpoint called");
        return "PatientController is working!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        logger.info("Updating patient with id: {}", id);
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setSpecies(patientDetails.getSpecies());
            patient.setBreed(patientDetails.getBreed());
            patient.setOwnerName(patientDetails.getOwnerName());
            patient.setOwnerContact(patientDetails.getOwnerContact());
            Patient updatedPatient = patientRepository.save(patient);
            logger.info("Updated patient: {}", updatedPatient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            logger.warn("Patient with id: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}