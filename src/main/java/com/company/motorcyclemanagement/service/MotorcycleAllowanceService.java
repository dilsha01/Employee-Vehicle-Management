package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.MotorcycleAllowanceDTO;
import com.company.motorcyclemanagement.entity.MotorcycleAllowance;
import com.company.motorcyclemanagement.repository.MotorcycleAllowanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotorcycleAllowanceService {
    @Autowired
    private MotorcycleAllowanceRepository motorcycleAllowanceRepository;

    // Get all Motorcycle Allowances
    public List<MotorcycleAllowanceDTO> getAllMotorcycleAllowances() {
        return motorcycleAllowanceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get Motorcycle Allowance by ID
    public MotorcycleAllowanceDTO getMotorcycleAllowanceById(Long id) {
        MotorcycleAllowance motorcycleAllowance = motorcycleAllowanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorcycle Allowance not found"));
        return convertToDTO(motorcycleAllowance);
    }

    // Create a new Motorcycle Allowance
    public MotorcycleAllowanceDTO createMotorcycleAllowance(MotorcycleAllowanceDTO motorcycleAllowanceDTO) {
        MotorcycleAllowance motorcycleAllowance = convertToEntity(motorcycleAllowanceDTO);
        motorcycleAllowance = motorcycleAllowanceRepository.save(motorcycleAllowance);
        return convertToDTO(motorcycleAllowance);
    }

    // Update an existing Motorcycle Allowance
    public MotorcycleAllowanceDTO updateMotorcycleAllowance(Long id, MotorcycleAllowanceDTO motorcycleAllowanceDTO) {
        Optional<MotorcycleAllowance> optionalAllowance = motorcycleAllowanceRepository.findById(id);
        if (optionalAllowance.isEmpty()) {
            throw new RuntimeException("Motorcycle Allowance not found");
        }

        MotorcycleAllowance motorcycleAllowance = optionalAllowance.get();
        motorcycleAllowance.setAmount(motorcycleAllowanceDTO.getAmount());
        motorcycleAllowance.setProvidedDate(motorcycleAllowanceDTO.getProvidedDate());

        motorcycleAllowance = motorcycleAllowanceRepository.save(motorcycleAllowance);
        return convertToDTO(motorcycleAllowance);
    }

    // Delete a Motorcycle Allowance
    public void deleteMotorcycleAllowance(Long id) {
        if (!motorcycleAllowanceRepository.existsById(id)) {
            throw new RuntimeException("Motorcycle Allowance not found");
        }
        motorcycleAllowanceRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private MotorcycleAllowanceDTO convertToDTO(MotorcycleAllowance motorcycleAllowance) {
        MotorcycleAllowanceDTO dto = new MotorcycleAllowanceDTO();
        dto.setAllowanceId(motorcycleAllowance.getAllowanceId());
        dto.setMotorcycleId(motorcycleAllowance.getMotorcycle().getMotorcycleId());
        dto.setAmount(motorcycleAllowance.getAmount());
        dto.setProvidedDate(motorcycleAllowance.getProvidedDate());
        return dto;
    }

    // Convert DTO to Entity
    private MotorcycleAllowance convertToEntity(MotorcycleAllowanceDTO dto) {
        MotorcycleAllowance motorcycleAllowance = new MotorcycleAllowance();
        motorcycleAllowance.setAmount(dto.getAmount());
        motorcycleAllowance.setProvidedDate(dto.getProvidedDate());
        return motorcycleAllowance;
    }
}
