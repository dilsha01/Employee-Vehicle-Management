package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.MotorcycleDTO;
import com.company.motorcyclemanagement.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public MotorcycleDTO getMotorcycleById(@PathVariable Long id) {
        return motorcycleService.getMotorcycleById(id);
    }
}
