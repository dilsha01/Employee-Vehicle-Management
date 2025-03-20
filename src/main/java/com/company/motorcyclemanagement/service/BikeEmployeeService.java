package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.BikeEmployeeDTO;
import com.company.motorcyclemanagement.entity.BikeEmployee;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.repository.BikeEmployeeRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import com.company.motorcyclemanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@CrossOrigin
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
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OtherEmployeeRepository otherEmployeeRepository;

    public BikeEmployeeDTO createBikeEmployee(BikeEmployeeDTO bikeEmployeeDTO) {
        Role role = null;
        OtherEmployee enteredBy = null;

        // Fetch Role if roleId is provided
        if (bikeEmployeeDTO.getRoleId() != null) {
            role = roleRepository.findById(bikeEmployeeDTO.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
        }

        // Fetch OtherEmployee if enteredById is provided
        if (bikeEmployeeDTO.getEnteredById() != null) {
            enteredBy = otherEmployeeRepository.findById(bikeEmployeeDTO.getEnteredById())
                    .orElseThrow(() -> new RuntimeException("EnteredBy Employee not found"));
        }

        BikeEmployee bikeEmployee = convertToEntity(bikeEmployeeDTO, role, enteredBy);
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

        if (bikeEmployee.getRole() != null) {
            dto.setRoleId(bikeEmployee.getRole().getRoleId()); // Assuming Role has getRoleId()
        }


        dto.setEnteredDate(bikeEmployee.getEnteredDate());
        return dto;
    }

    // Convert DTO to Entity
    private BikeEmployee convertToEntity(BikeEmployeeDTO dto, Role role, OtherEmployee enteredBy) {
        BikeEmployee bikeEmployee = new BikeEmployee();
        bikeEmployee.setName(dto.getName());
        bikeEmployee.setContactNo(dto.getContactNo());
        bikeEmployee.setEmail(dto.getEmail());

        if (role != null) {
            bikeEmployee.setRole(role);
        }

        if (enteredBy != null) {
            bikeEmployee.setEnteredBy(enteredBy);
        }

        bikeEmployee.setEnteredDate(dto.getEnteredDate());
        return bikeEmployee;
    }

}
