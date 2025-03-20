package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.AccidentDTO;
import com.company.motorcyclemanagement.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {
    @Autowired
    private AccidentService accidentService;

    // Get all accidents
    @GetMapping
    public List<AccidentDTO> getAllAccidents() {
        return accidentService.getAllAccidents();
    }

    // Get accident by ID
    @GetMapping("/{id}")
    public AccidentDTO getAccidentById(@PathVariable Long id) {
        return accidentService.getAccidentById(id);
    }

    // Save accident (Create)
    @PostMapping
    public AccidentDTO saveAccident(@RequestBody AccidentDTO accidentDTO) {
        return accidentService.saveAccident(accidentDTO);
    }

    // Update accident
    @PutMapping("/{id}")
    public AccidentDTO updateAccident(@PathVariable Long id, @RequestBody AccidentDTO accidentDTO) {
        return accidentService.updateAccident(id, accidentDTO);
    }

    // Delete accident
    @DeleteMapping("/{id}")
    public void deleteAccident(@PathVariable Long id) {
        accidentService.deleteAccident(id);
    }
}
