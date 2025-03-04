package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.RoleDTO;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody Role role) {
        try {
            Role savedRole = roleService.saveRole(role);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RoleDTO(savedRole.getRoleId(), savedRole.getUserRole()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
