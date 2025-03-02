package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.LicenseDTO;
import com.company.motorcyclemanagement.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    // Get all licenses
    @GetMapping
    public List<LicenseDTO> getAllLicenses() {
        return licenseService.getAllLicenses();
    }

    // Get license by ID
    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> getLicenseById(@PathVariable Long id) {
        return ResponseEntity.ok(licenseService.getLicenseById(id));
    }

    // Create a new license
    @PostMapping
    public ResponseEntity<LicenseDTO> createLicense(@RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.createLicense(licenseDTO));
    }

    // Update an existing license
    @PutMapping("/{id}")
    public ResponseEntity<LicenseDTO> updateLicense(@PathVariable Long id, @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok(licenseService.updateLicense(id, licenseDTO));
    }

    // Delete a license
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLicense(@PathVariable Long id) {
        licenseService.deleteLicense(id);
        return ResponseEntity.ok("License deleted successfully");
    }
}
