package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Treatment;
import com.example.demo.repository.TreatmentRepository;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment getTreatmentById(Long id) {
        return treatmentRepository.findById(id).orElse(null);
    }

    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public void deleteTreatment(Long id) {
        treatmentRepository.deleteById(id);
    }
}