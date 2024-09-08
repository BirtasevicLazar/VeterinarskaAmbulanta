package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;

import java.util.List;

@Service
public class VisitRecordService {

    @Autowired
    private VisitRecordRepository visitRecordRepository;

    public List<VisitRecord> getAllVisitRecords() {
        return visitRecordRepository.findAll();
    }

    public VisitRecord getVisitRecordById(Long id) {
        return visitRecordRepository.findById(id).orElse(null);
    }

    public VisitRecord saveVisitRecord(VisitRecord visitRecord) {
        return visitRecordRepository.save(visitRecord);
    }

    public void deleteVisitRecord(Long id) {
        visitRecordRepository.deleteById(id);
    }
}