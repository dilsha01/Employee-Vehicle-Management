package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.RunningChartDTO;
import com.company.motorcyclemanagement.service.RunningChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/running-chart")
public class RunningChartController {
    @Autowired
    private RunningChartService runningChartService;

    // Get all Running Charts
    @GetMapping
    public List<RunningChartDTO> getAllRunningCharts() {
        return runningChartService.getAllRunningCharts();
    }

    // Get Running Chart by ID
    @GetMapping("/{id}")
    public ResponseEntity<RunningChartDTO> getRunningChartById(@PathVariable Long id) {
        return ResponseEntity.ok(runningChartService.getRunningChartById(id));
    }

    // Create a new Running Chart
    @PostMapping
    public ResponseEntity<RunningChartDTO> createRunningChart(@RequestBody RunningChartDTO runningChartDTO) {
        return ResponseEntity.ok(runningChartService.createRunningChart(runningChartDTO));
    }

    // Update an existing Running Chart
    @PutMapping("/{id}")
    public ResponseEntity<RunningChartDTO> updateRunningChart(@PathVariable Long id, @RequestBody RunningChartDTO runningChartDTO) {
        return ResponseEntity.ok(runningChartService.updateRunningChart(id, runningChartDTO));
    }

    // Delete a Running Chart
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRunningChart(@PathVariable Long id) {
        runningChartService.deleteRunningChart(id);
        return ResponseEntity.ok("Running Chart deleted successfully");
    }
}
