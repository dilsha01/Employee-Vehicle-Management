package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.MaintenanceDTO;
import com.company.motorcyclemanagement.entity.Maintenance;
import com.company.motorcyclemanagement.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    // Get all maintenance records
    public List<MaintenanceDTO> getAllMaintenance() {
        return maintenanceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get maintenance by ID
    public MaintenanceDTO getMaintenanceById(Long id) {
        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance record not found"));
        return convertToDTO(maintenance);
    }

    // Create new maintenance record
    public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = convertToEntity(maintenanceDTO);
        maintenance = maintenanceRepository.save(maintenance);
        return convertToDTO(maintenance);
    }

    // Update maintenance record
    public MaintenanceDTO updateMaintenance(Long id, MaintenanceDTO maintenanceDTO) {
        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(id);
        if (optionalMaintenance.isEmpty()) {
            throw new RuntimeException("Maintenance record not found");
        }

        Maintenance maintenance = optionalMaintenance.get();
        maintenance.setMaintenanceDate(maintenanceDTO.getMaintenanceDate());
        maintenance.setAmount(maintenanceDTO.getAmount());

        maintenance = maintenanceRepository.save(maintenance);
        return convertToDTO(maintenance);
    }

    // Delete maintenance record
    public void deleteMaintenance(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance record not found");
        }
        maintenanceRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private MaintenanceDTO convertToDTO(Maintenance maintenance) {
        MaintenanceDTO dto = new MaintenanceDTO();
        dto.setMaintenanceId(maintenance.getMaintenanceId());
        dto.setMotorcycleId(maintenance.getMotorcycle().getMotorcycleId());
        dto.setMaintenanceDate(maintenance.getMaintenanceDate());
        dto.setAmount(maintenance.getAmount());
        return dto;
    }

    // Convert DTO to Entity
    private Maintenance convertToEntity(MaintenanceDTO dto) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceDate(dto.getMaintenanceDate());
        maintenance.setAmount(dto.getAmount());
        return maintenance;
    }
}
