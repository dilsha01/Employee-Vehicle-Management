package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.BikeEmployeeDTO;
import com.company.motorcyclemanagement.service.BikeEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bike-employee")
public class BikeEmployeeController {
    @Autowired
    private BikeEmployeeService bikeEmployeeService;

    // Get all BikeEmployees
    @GetMapping
    public List<BikeEmployeeDTO> getAllBikeEmployees() {
        return bikeEmployeeService.getAllBikeEmployees();
    }

    // Get a single BikeEmployee by ID
    @GetMapping("/{id}")
    public ResponseEntity<BikeEmployeeDTO> getBikeEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(bikeEmployeeService.getBikeEmployeeById(id));
    }

    // Create a new BikeEmployee
    @PostMapping
    public ResponseEntity<BikeEmployeeDTO> createBikeEmployee(@RequestBody BikeEmployeeDTO bikeEmployeeDTO) {
        return ResponseEntity.ok(bikeEmployeeService.createBikeEmployee(bikeEmployeeDTO));
    }

    // Update an existing BikeEmployee
    @PutMapping("/{id}")
    public ResponseEntity<BikeEmployeeDTO> updateBikeEmployee(@PathVariable Long id, @RequestBody BikeEmployeeDTO bikeEmployeeDTO) {
        return ResponseEntity.ok(bikeEmployeeService.updateBikeEmployee(id, bikeEmployeeDTO));
    }

    // Delete a BikeEmployee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBikeEmployee(@PathVariable Long id) {
        bikeEmployeeService.deleteBikeEmployee(id);
        return ResponseEntity.ok("BikeEmployee deleted successfully");
    }
}
