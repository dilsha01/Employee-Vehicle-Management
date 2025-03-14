package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.RoleDTO;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

//    public Role saveRole(Role role) {
//        return roleRepository.save(role);
//    }

    public Role saveRole(Role role) {
        // Check if roleId already exists
        Optional<Role> existingRole = roleRepository.findById(role.getRoleId());
        if (existingRole.isPresent()) {
            throw new IllegalArgumentException("Role ID already exists. Choose a unique ID.");
        }
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }

    private RoleDTO convertToDTO(Role role) {
        return new RoleDTO(role.getRoleId(), role.getUserRole());
    }

}
