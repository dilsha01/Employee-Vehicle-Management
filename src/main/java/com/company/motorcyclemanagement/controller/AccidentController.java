package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.AccidentDTO;
import com.company.motorcyclemanagement.entity.Accident;
import com.company.motorcyclemanagement.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {
    @Autowired
    private AccidentService accidentService;

    @GetMapping
    public List<AccidentDTO> getAllAccidents() {
        return accidentService.getAllAccidents();
    }

    @GetMapping("/{id}")
    public AccidentDTO getAccidentById(@PathVariable Long id) {
        return accidentService.getAccidentById(id);
    }

    @PostMapping
    public AccidentDTO saveAccident(@RequestBody Accident accident) {
        return accidentService.convertToDTO(accidentService.saveAccident(accident));
    }

    @DeleteMapping("/{id}")
    public void deleteAccident(@PathVariable Long id) {
        accidentService.deleteAccident(id);
    }
}
