package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Treatment;
import com.example.demo.service.TreatmentService;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{id}")
    public Treatment getTreatmentById(@PathVariable Long id) {
        return treatmentService.getTreatmentById(id);
    }

    @PostMapping
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        return treatmentService.saveTreatment(treatment);
    }

    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
    }
}