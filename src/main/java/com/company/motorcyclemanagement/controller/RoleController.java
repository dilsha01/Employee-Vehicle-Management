package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.RoleDTO;
import com.company.motorcyclemanagement.entity.Role;
import com.company.motorcyclemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RoleDTO saveRole(@RequestBody Role role) {
        return roleService.getRoleById(roleService.saveRole(role).getRoleId());
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
