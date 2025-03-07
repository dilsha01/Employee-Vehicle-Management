//package com.company.motorcyclemanagement.service;
//
//import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
//import com.company.motorcyclemanagement.entity.Branch;
//import com.company.motorcyclemanagement.entity.OtherEmployee;
//import com.company.motorcyclemanagement.entity.Role;
//import com.company.motorcyclemanagement.repository.BranchRepository;
//import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
//import com.company.motorcyclemanagement.repository.RoleRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class OtherEmployeeService {
//    private static final Logger logger = LoggerFactory.getLogger(OtherEmployeeService.class);
//
//    private final OtherEmployeeRepository otherEmployeeRepository;
//    private final RoleRepository roleRepository;
//    private final BranchRepository branchRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public OtherEmployeeService(OtherEmployeeRepository otherEmployeeRepository,
//                                RoleRepository roleRepository,
//                                BranchRepository branchRepository,
//                                PasswordEncoder passwordEncoder) {
//        this.otherEmployeeRepository = otherEmployeeRepository;
//        this.roleRepository = roleRepository;
//        this.branchRepository = branchRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public List<OtherEmployeeDTO> getAllOtherEmployees() {
//        return otherEmployeeRepository.findAll()
//                .stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public OtherEmployeeDTO getOtherEmployeeById(Long id) {
//        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));
//        return convertToDTO(otherEmployee);
//    }
//
//    @Transactional
//    public OtherEmployeeDTO createOtherEmployee(OtherEmployeeDTO otherEmployeeDTO) {
//        if (otherEmployeeDTO == null) {
//            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
//        }
//
//        OtherEmployee otherEmployee = convertToEntity(otherEmployeeDTO);
//        otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
//        otherEmployee = otherEmployeeRepository.save(otherEmployee);
//        return convertToDTO(otherEmployee);
//    }
//
//    @Transactional
//    public OtherEmployeeDTO updateOtherEmployee(Long id, OtherEmployeeDTO otherEmployeeDTO) {
//        if (otherEmployeeDTO == null) {
//            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
//        }
//
//        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));
//
//        otherEmployee.setName(otherEmployeeDTO.getName());
//        otherEmployee.setContactNo(otherEmployeeDTO.getContactNo());
//        otherEmployee.setEmail(otherEmployeeDTO.getEmail());
//
//        // Update password only if provided
//        if (otherEmployeeDTO.getPassword() != null && !otherEmployeeDTO.getPassword().isEmpty()) {
//            otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
//        }
//
//        otherEmployee = otherEmployeeRepository.save(otherEmployee);
//        return convertToDTO(otherEmployee);
//    }
//
//    @Transactional
//    public void deleteOtherEmployee(Long id) {
//        if (!otherEmployeeRepository.existsById(id)) {
//            throw new EntityNotFoundException("OtherEmployee with ID " + id + " not found");
//        }
//        otherEmployeeRepository.deleteById(id);
//    }
//
//    public boolean authenticate(String email, String password) {
//        Optional<OtherEmployee> optionalEmployee = otherEmployeeRepository.findByEmail(email);
//
//        if (optionalEmployee.isEmpty()) {
//            logger.warn("User not found with email: {}", email);
//            return false;
//        }
//
//        OtherEmployee employee = optionalEmployee.get();
//        logger.info("User found: {}", employee.getEmail());
//        logger.info("Stored hashed password: {}", employee.getPassword());
//
//        // Correct comparison without re-hashing
//        boolean match = passwordEncoder.matches(password, employee.getPassword());
//
//        logger.info("Password Match Result: {}", match);
//
//        return match;
//    }
//
//
//
//
//    public OtherEmployeeDTO getOtherEmployeeByEmail(String email) {
//        OtherEmployee employee = otherEmployeeRepository.findByEmail(email)
//                .orElseThrow(() -> new EntityNotFoundException("Employee with email " + email + " not found"));
//        return convertToDTO(employee);
//    }
//
//    private OtherEmployeeDTO convertToDTO(OtherEmployee otherEmployee) {
//        OtherEmployeeDTO dto = new OtherEmployeeDTO();
//        dto.setOtherEmployeeId(otherEmployee.getOtherEmployeeId());
//        dto.setName(otherEmployee.getName());
//        dto.setContactNo(otherEmployee.getContactNo());
//        dto.setEmail(otherEmployee.getEmail());
//
//        if (otherEmployee.getRole() != null) {
//            dto.setRoleId(otherEmployee.getRole().getRoleId());
//        }
//        if (otherEmployee.getBranch() != null) {
//            dto.setBranchId(otherEmployee.getBranch().getBranchId());
//        }
//
//        return dto;
//    }
//
//    private OtherEmployee convertToEntity(OtherEmployeeDTO dto) {
//        if (dto == null) {
//            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
//        }
//
//        OtherEmployee otherEmployee = new OtherEmployee();
//        otherEmployee.setName(dto.getName());
//        otherEmployee.setContactNo(dto.getContactNo());
//        otherEmployee.setEmail(dto.getEmail());
//
//        // Set role if available
//        if (dto.getRoleId() != null) {
//            Role role = roleRepository.findById(dto.getRoleId())
//                    .orElseThrow(() -> new EntityNotFoundException("Role with ID " + dto.getRoleId() + " not found"));
//            otherEmployee.setRole(role);
//        }
//
//        // Set branch if available
//        if (dto.getBranchId() != null) {
//            Branch branch = branchRepository.findById(dto.getBranchId())
//                    .orElseThrow(() -> new EntityNotFoundException("Branch with ID " + dto.getBranchId() + " not found"));
//            otherEmployee.setBranch(branch);
//        }
//
//        return otherEmployee;
//    }
//}

package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.OtherEmployeeDTO;
import com.company.motorcyclemanagement.entity.Branch;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.repository.BranchRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import com.company.motorcyclemanagement.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherEmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(OtherEmployeeService.class);

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
        return otherEmployeeRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));
    }

    @Transactional
    public OtherEmployeeDTO createOtherEmployee(OtherEmployeeDTO otherEmployeeDTO) {
        if (otherEmployeeDTO == null) {
            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
        }

        OtherEmployee otherEmployee = convertToEntity(otherEmployeeDTO);
        if (otherEmployeeDTO.getPassword() != null && !otherEmployeeDTO.getPassword().isEmpty()) {
            otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
        }
        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    @Transactional
    public OtherEmployeeDTO updateOtherEmployee(Long id, OtherEmployeeDTO otherEmployeeDTO) {
        if (otherEmployeeDTO == null) {
            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
        }

        OtherEmployee otherEmployee = otherEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OtherEmployee with ID " + id + " not found"));

        otherEmployee.setName(otherEmployeeDTO.getName());
        otherEmployee.setContactNo(otherEmployeeDTO.getContactNo());
        otherEmployee.setEmail(otherEmployeeDTO.getEmail());

        if (otherEmployeeDTO.getPassword() != null && !otherEmployeeDTO.getPassword().isEmpty()) {
            otherEmployee.setPassword(passwordEncoder.encode(otherEmployeeDTO.getPassword()));
        }

        otherEmployee = otherEmployeeRepository.save(otherEmployee);
        return convertToDTO(otherEmployee);
    }

    @Transactional
    public void deleteOtherEmployee(Long id) {
        if (!otherEmployeeRepository.existsById(id)) {
            throw new EntityNotFoundException("OtherEmployee with ID " + id + " not found");
        }
        otherEmployeeRepository.deleteById(id);
    }

    public boolean authenticate(String email, String password) {
        return otherEmployeeRepository.findByEmail(email)
                .map(employee -> {
                    boolean match = passwordEncoder.matches(password, employee.getPassword());
                    logger.info("Authentication attempt for email: {} - Success: {}", email, match);
                    return match;
                })
                .orElseGet(() -> {
                    logger.warn("Authentication failed: User not found with email: {}", email);
                    return false;
                });
    }

    public OtherEmployeeDTO getOtherEmployeeByEmail(String email) {
        return otherEmployeeRepository.findByEmail(email)
                .map(this::convertToDTO)
                .orElseThrow(() -> new EntityNotFoundException("Employee with email " + email + " not found"));
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
        if (dto == null) {
            throw new IllegalArgumentException("OtherEmployeeDTO cannot be null");
        }

        OtherEmployee otherEmployee = new OtherEmployee();
        otherEmployee.setName(dto.getName());
        otherEmployee.setContactNo(dto.getContactNo());
        otherEmployee.setEmail(dto.getEmail());

        if (dto.getRoleId() != null) {
            Role role = roleRepository.findById(dto.getRoleId())
                    .orElseThrow(() -> new EntityNotFoundException("Role with ID " + dto.getRoleId() + " not found"));
            otherEmployee.setRole(role);
        }

        if (dto.getBranchId() != null) {
            Branch branch = branchRepository.findById(dto.getBranchId())
                    .orElseThrow(() -> new EntityNotFoundException("Branch with ID " + dto.getBranchId() + " not found"));
            otherEmployee.setBranch(branch);
        }

        return otherEmployee;
    }
}
