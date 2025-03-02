package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.BikeEmployeeDTO;
import com.company.motorcyclemanagement.entity.BikeEmployee;
import com.company.motorcyclemanagement.repository.BikeEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BikeEmployeeService {
    @Autowired
    private BikeEmployeeRepository bikeEmployeeRepository;

    // Get all BikeEmployees
    public List<BikeEmployeeDTO> getAllBikeEmployees() {
        return bikeEmployeeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get a single BikeEmployee by ID
    public BikeEmployeeDTO getBikeEmployeeById(Long id) {
        BikeEmployee bikeEmployee = bikeEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BikeEmployee not found"));
        return convertToDTO(bikeEmployee);
    }

    // Create a new BikeEmployee
    public BikeEmployeeDTO createBikeEmployee(BikeEmployeeDTO bikeEmployeeDTO) {
        BikeEmployee bikeEmployee = convertToEntity(bikeEmployeeDTO);
        bikeEmployee = bikeEmployeeRepository.save(bikeEmployee);
        return convertToDTO(bikeEmployee);
    }

    // Update an existing BikeEmployee
    public BikeEmployeeDTO updateBikeEmployee(Long id, BikeEmployeeDTO bikeEmployeeDTO) {
        Optional<BikeEmployee> optionalBikeEmployee = bikeEmployeeRepository.findById(id);
        if (optionalBikeEmployee.isEmpty()) {
            throw new RuntimeException("BikeEmployee not found");
        }

        BikeEmployee bikeEmployee = optionalBikeEmployee.get();
        bikeEmployee.setName(bikeEmployeeDTO.getName());
        bikeEmployee.setContactNo(bikeEmployeeDTO.getContactNo());
        bikeEmployee.setEmail(bikeEmployeeDTO.getEmail());

        bikeEmployee = bikeEmployeeRepository.save(bikeEmployee);
        return convertToDTO(bikeEmployee);
    }

    // Delete a BikeEmployee
    public void deleteBikeEmployee(Long id) {
        if (!bikeEmployeeRepository.existsById(id)) {
            throw new RuntimeException("BikeEmployee not found");
        }
        bikeEmployeeRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private BikeEmployeeDTO convertToDTO(BikeEmployee bikeEmployee) {
        BikeEmployeeDTO dto = new BikeEmployeeDTO();
        dto.setBikeEmployeeId(bikeEmployee.getBikeEmployeeId());
        dto.setName(bikeEmployee.getName());
        dto.setContactNo(bikeEmployee.getContactNo());
        dto.setEmail(bikeEmployee.getEmail());
        return dto;
    }

    // Convert DTO to Entity
    private BikeEmployee convertToEntity(BikeEmployeeDTO dto) {
        BikeEmployee bikeEmployee = new BikeEmployee();
        bikeEmployee.setName(dto.getName());
        bikeEmployee.setContactNo(dto.getContactNo());
        bikeEmployee.setEmail(dto.getEmail());
        return bikeEmployee;
    }
}
