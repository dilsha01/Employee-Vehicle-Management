package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.InsuranceDTO;
import com.company.motorcyclemanagement.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    // Get All Insurances
    @GetMapping
    public List<InsuranceDTO> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }

    // Get Insurance by ID
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDTO> getInsuranceById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceService.getInsuranceById(id));
    }

    // Create Insurance
    @PostMapping
    public ResponseEntity<InsuranceDTO> createInsurance(@RequestBody InsuranceDTO insuranceDTO) {
        return ResponseEntity.ok(insuranceService.createInsurance(insuranceDTO));
    }

    // Update Insurance
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceDTO> updateInsurance(@PathVariable Long id, @RequestBody InsuranceDTO insuranceDTO) {
        return ResponseEntity.ok(insuranceService.updateInsurance(id, insuranceDTO));
    }

    // Delete Insurance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return ResponseEntity.ok("Insurance deleted successfully");
    }
}
