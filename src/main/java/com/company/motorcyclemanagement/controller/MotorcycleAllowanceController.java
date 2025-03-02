package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.MotorcycleAllowanceDTO;
import com.company.motorcyclemanagement.service.MotorcycleAllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle-allowance")
public class MotorcycleAllowanceController {
    @Autowired
    private MotorcycleAllowanceService motorcycleAllowanceService;

    // Get all Motorcycle Allowances
    @GetMapping
    public List<MotorcycleAllowanceDTO> getAllMotorcycleAllowances() {
        return motorcycleAllowanceService.getAllMotorcycleAllowances();
    }

    // Get Motorcycle Allowance by ID
    @GetMapping("/{id}")
    public ResponseEntity<MotorcycleAllowanceDTO> getMotorcycleAllowanceById(@PathVariable Long id) {
        return ResponseEntity.ok(motorcycleAllowanceService.getMotorcycleAllowanceById(id));
    }

    // Create a new Motorcycle Allowance
    @PostMapping
    public ResponseEntity<MotorcycleAllowanceDTO> createMotorcycleAllowance(@RequestBody MotorcycleAllowanceDTO motorcycleAllowanceDTO) {
        return ResponseEntity.ok(motorcycleAllowanceService.createMotorcycleAllowance(motorcycleAllowanceDTO));
    }

    // Update an existing Motorcycle Allowance
    @PutMapping("/{id}")
    public ResponseEntity<MotorcycleAllowanceDTO> updateMotorcycleAllowance(@PathVariable Long id, @RequestBody MotorcycleAllowanceDTO motorcycleAllowanceDTO) {
        return ResponseEntity.ok(motorcycleAllowanceService.updateMotorcycleAllowance(id, motorcycleAllowanceDTO));
    }

    // Delete a Motorcycle Allowance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMotorcycleAllowance(@PathVariable Long id) {
        motorcycleAllowanceService.deleteMotorcycleAllowance(id);
        return ResponseEntity.ok("Motorcycle Allowance deleted successfully");
    }
}
