package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Veterinarian;
import com.example.demo.repository.VeterinarianRepository;

import java.util.List;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public Veterinarian getVeterinarianById(Long id) {
        return veterinarianRepository.findById(id).orElse(null);
    }

    public Veterinarian saveVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    public void deleteVeterinarian(Long id) {
        veterinarianRepository.deleteById(id);
    }
}