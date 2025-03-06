package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
import com.company.motorcyclemanagement.entity.Branch;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.repository.BranchRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import com.company.motorcyclemanagement.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherEmployeeService {
    private final OtherEmployeeRepository otherEmployeeRepository;
    private final RoleRepository roleRepository;
    private final BranchRepository branchRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OtherEmployeeService(OtherEmployeeRepository otherEmployeeRepository,
                                RoleRepository roleRepository,
                                BranchRepository branchRepository,
                                PasswordEncoder passwordEncoder) {
        this.otherEmployeeRepository = otherEmployeeRepository;
        this.roleRepository = roleRepository;
        this.branchRepository = branchRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<OtherEmployeeDTO> getAllOtherEmployees() {
        return otherEmployeeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OtherEmployeeDTO getOtherEmployeeById(Long id) {
        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));
        return convertToDTO(otherEmployee);
    }

    public OtherEmployeeDTO createOtherEmployee(OtherEmployeeDTO otherEmployeeDTO) {
        OtherEmployee otherEmployee = convertToEntity(otherEmployeeDTO);
        otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    public OtherEmployeeDTO updateOtherEmployee(Long id, OtherEmployeeDTO otherEmployeeDTO) {
        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));

        otherEmployee.setName(otherEmployeeDTO.getName());
        otherEmployee.setContactNo(otherEmployeeDTO.getContactNo());
        otherEmployee.setEmail(otherEmployeeDTO.getEmail());

        // Update password only if provided
        if (otherEmployeeDTO.getPassword() != null && !otherEmployeeDTO.getPassword().isEmpty()) {
            otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
        }

        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    public void deleteOtherEmployee(Long id) {
        if (!otherEmployeeRepository.existsById(id)) {
            throw new EntityNotFoundException("OtherEmployee with ID " + id + " not found");
        }
        otherEmployeeRepository.deleteById(id);
    }

    // Authentication method
    public boolean authenticate(String name, String password) {
        Optional<OtherEmployee> optionalEmployee = otherEmployeeRepository.findByName(name);

        if (optionalEmployee.isEmpty()) { // Correct way to check if Optional is empty
            System.out.println("User not found: " + name);
            return false;
        }

        OtherEmployee employee = optionalEmployee.get(); // Retrieve the actual object

        System.out.println("Stored password (hashed): " + employee.getPassword());
        System.out.println("Entered password (plain): " + password);

        boolean match = passwordEncoder.matches(password, employee.getPassword());
        System.out.println("Password Match: " + match);

        return match;
    }



    public OtherEmployeeDTO getOtherEmployeeByEmail(String name) {
        OtherEmployee employee = otherEmployeeRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Employee with name " + name + " not found"));
        return convertToDTO(employee);
    }

    private OtherEmployeeDTO convertToDTO(OtherEmployee otherEmployee) {
        OtherEmployeeDTO dto = new OtherEmployeeDTO();
        dto.setOtherEmployeeId(otherEmployee.getOtherEmployeeId());
        dto.setName(otherEmployee.getName());
        dto.setContactNo(otherEmployee.getContactNo());
        dto.setEmail(otherEmployee.getEmail());

        if (otherEmployee.getRole() != null) {
            dto.setRoleId(otherEmployee.getRole().getRoleId());
        }
        if (otherEmployee.getBranch() != null) {
            dto.setBranchId(otherEmployee.getBranch().getBranchId());
        }

        return dto;
    }

    private OtherEmployee convertToEntity(OtherEmployeeDTO dto) {
        OtherEmployee otherEmployee = new OtherEmployee();
        otherEmployee.setName(dto.getName());
        otherEmployee.setContactNo(dto.getContactNo());
        otherEmployee.setEmail(dto.getEmail());

        // Set role if available
        if (dto.getRoleId() != null) {
            Role role = roleRepository.findById(dto.getRoleId())
                    .orElseThrow(() -> new EntityNotFoundException("Role with ID " + dto.getRoleId() + " not found"));
            otherEmployee.setRole(role);
        }

        // Set branch if available
        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId())
                    .orElseThrow(() -> new EntityNotFoundException("Branch with ID " + dto.getBranchId() + " not found"));
            otherEmployee.setBranch(branch);
        }

        return otherEmployee;
    }
}
