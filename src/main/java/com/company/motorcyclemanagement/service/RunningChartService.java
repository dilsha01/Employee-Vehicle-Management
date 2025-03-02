package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.RunningChartDTO;
import com.company.motorcyclemanagement.entity.RunningChart;
import com.company.motorcyclemanagement.repository.RunningChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RunningChartService {
    @Autowired
    private RunningChartRepository runningChartRepository;

    // Get all Running Charts
    public List<RunningChartDTO> getAllRunningCharts() {
        return runningChartRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get Running Chart by ID
    public RunningChartDTO getRunningChartById(Long id) {
        RunningChart runningChart = runningChartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Running Chart not found"));
        return convertToDTO(runningChart);
    }

    // Create a new Running Chart
    public RunningChartDTO createRunningChart(RunningChartDTO runningChartDTO) {
        RunningChart runningChart = convertToEntity(runningChartDTO);
        runningChart = runningChartRepository.save(runningChart);
        return convertToDTO(runningChart);
    }

    // Update an existing Running Chart
    public RunningChartDTO updateRunningChart(Long id, RunningChartDTO runningChartDTO) {
        Optional<RunningChart> optionalRunningChart = runningChartRepository.findById(id);
        if (optionalRunningChart.isEmpty()) {
            throw new RuntimeException("Running Chart not found");
        }

        RunningChart runningChart = optionalRunningChart.get();
        runningChart.setStartLocation(runningChartDTO.getStartLocation());
        runningChart.setEndLocation(runningChartDTO.getEndLocation());
        runningChart.setStartOdometer(runningChartDTO.getStartOdometer());
        runningChart.setEndOdometer(runningChartDTO.getEndOdometer());
        runningChart.setDate(runningChartDTO.getDate());

        runningChart = runningChartRepository.save(runningChart);
        return convertToDTO(runningChart);
    }

    // Delete a Running Chart
    public void deleteRunningChart(Long id) {
        if (!runningChartRepository.existsById(id)) {
            throw new RuntimeException("Running Chart not found");
        }
        runningChartRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private RunningChartDTO convertToDTO(RunningChart runningChart) {
        RunningChartDTO dto = new RunningChartDTO();
        dto.setRunningChartId(runningChart.getRunningChartId());
        dto.setMotorcycleId(runningChart.getMotorcycle().getMotorcycleId());
        dto.setStartLocation(runningChart.getStartLocation());
        dto.setEndLocation(runningChart.getEndLocation());
        dto.setStartOdometer(runningChart.getStartOdometer());
        dto.setEndOdometer(runningChart.getEndOdometer());
        dto.setDate(runningChart.getDate());
        return dto;
    }

    // Convert DTO to Entity
    private RunningChart convertToEntity(RunningChartDTO dto) {
        RunningChart runningChart = new RunningChart();
        runningChart.setStartLocation(dto.getStartLocation());
        runningChart.setEndLocation(dto.getEndLocation());
        runningChart.setStartOdometer(dto.getStartOdometer());
        runningChart.setEndOdometer(dto.getEndOdometer());
        runningChart.setDate(dto.getDate());
        return runningChart;
    }
}
