package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.MotorcycleDTO;
import com.company.motorcyclemanagement.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {
    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public List<MotorcycleDTO> getAllMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotorcycleDTO> getMotorcycleById(@PathVariable Long id) {
        return ResponseEntity.ok(motorcycleService.getMotorcycleById(id));
    }

    @PostMapping
    public ResponseEntity<MotorcycleDTO> createMotorcycle(@RequestBody MotorcycleDTO motorcycleDTO) {
        return ResponseEntity.ok(motorcycleService.createMotorcycle(motorcycleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotorcycleDTO> updateMotorcycle(@PathVariable Long id, @RequestBody MotorcycleDTO motorcycleDTO) {
        return ResponseEntity.ok(motorcycleService.updateMotorcycle(id, motorcycleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorcycle(@PathVariable Long id) {
        motorcycleService.deleteMotorcycle(id);
        return ResponseEntity.noContent().build();
    }
}