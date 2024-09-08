package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;

import java.util.List;

@RestController
@RequestMapping("/visit-records")
public class VisitRecordController {

    @Autowired
    private VisitRecordService visitRecordService;

    @GetMapping
    public List<VisitRecord> getAllVisitRecords() {
        return visitRecordService.getAllVisitRecords();
    }

    @GetMapping("/{id}")
    public VisitRecord getVisitRecordById(@PathVariable Long id) {
        return visitRecordService.getVisitRecordById(id);
    }

    @PostMapping
    public VisitRecord createVisitRecord(@RequestBody VisitRecord visitRecord) {
        return visitRecordService.saveVisitRecord(visitRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteVisitRecord(@PathVariable Long id) {
        visitRecordService.deleteVisitRecord(id);
    }
}