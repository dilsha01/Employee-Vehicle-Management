package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.MaintenanceDTO;
import com.company.motorcyclemanagement.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maintenance")
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    // Get all maintenance records
    @GetMapping
    public List<MaintenanceDTO> getAllMaintenance() {
        return maintenanceService.getAllMaintenance();
    }

    // Get maintenance by ID
    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> getMaintenanceById(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceService.getMaintenanceById(id));
    }

    // Create new maintenance record
    @PostMapping
    public ResponseEntity<MaintenanceDTO> createMaintenance(@RequestBody MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.ok(maintenanceService.createMaintenance(maintenanceDTO));
    }

    // Update maintenance record
    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceDTO> updateMaintenance(@PathVariable Long id, @RequestBody MaintenanceDTO maintenanceDTO) {
        return ResponseEntity.ok(maintenanceService.updateMaintenance(id, maintenanceDTO));
    }

    // Delete maintenance record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.ok("Maintenance record deleted successfully");
    }
}
