package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Veterinarian;
import com.example.demo.service.VeterinarianService;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianService.getAllVeterinarians();
    }

    @GetMapping("/{id}")
    public Veterinarian getVeterinarianById(@PathVariable Long id) {
        return veterinarianService.getVeterinarianById(id);
    }

    @PostMapping
    public Veterinarian createVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianService.saveVeterinarian(veterinarian);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterinarian(@PathVariable Long id) {
        veterinarianService.deleteVeterinarian(id);
    }
}