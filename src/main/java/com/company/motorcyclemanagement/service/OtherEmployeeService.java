package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherEmployeeService {
    @Autowired
    private OtherEmployeeRepository otherEmployeeRepository;

    public List<OtherEmployeeDTO> getAllOtherEmployees() {
        return otherEmployeeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OtherEmployeeDTO getOtherEmployeeById(Long id) {
        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OtherEmployee not found"));
        return convertToDTO(otherEmployee);
    }

    public OtherEmployeeDTO createOtherEmployee(OtherEmployeeDTO otherEmployeeDTO) {
        OtherEmployee otherEmployee = convertToEntity(otherEmployeeDTO);
        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    public OtherEmployeeDTO updateOtherEmployee(Long id, OtherEmployeeDTO otherEmployeeDTO) {
        Optional<OtherEmployee> optionalOtherEmployee = otherEmployeeRepository.findById(id);
        if (optionalOtherEmployee.isEmpty()) {
            throw new RuntimeException("OtherEmployee not found");
        }

        OtherEmployee otherEmployee = optionalOtherEmployee.get();
        otherEmployee.setName(otherEmployeeDTO.getName());
        otherEmployee.setContactNo(otherEmployeeDTO.getContactNo());
        otherEmployee.setEmail(otherEmployeeDTO.getEmail());

        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    public void deleteOtherEmployee(Long id) {
        if (!otherEmployeeRepository.existsById(id)) {
            throw new RuntimeException("OtherEmployee not found");
        }
        otherEmployeeRepository.deleteById(id);
    }

    private OtherEmployeeDTO convertToDTO(OtherEmployee otherEmployee) {
        OtherEmployeeDTO dto = new OtherEmployeeDTO();
        dto.setOtherEmployeeId(otherEmployee.getOtherEmployeeId());
        dto.setName(otherEmployee.getName());
        dto.setContactNo(otherEmployee.getContactNo());
        dto.setEmail(otherEmployee.getEmail());
        return dto;
    }

    private OtherEmployee convertToEntity(OtherEmployeeDTO dto) {
        OtherEmployee otherEmployee = new OtherEmployee();
        otherEmployee.setName(dto.getName());
        otherEmployee.setContactNo(dto.getContactNo());
        otherEmployee.setEmail(dto.getEmail());
        return otherEmployee;
    }
}
