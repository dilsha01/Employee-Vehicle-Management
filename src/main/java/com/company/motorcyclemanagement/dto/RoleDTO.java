package com.company.motorcyclemanagement.dto;

public class RoleDTO {
    private Long roleId;
    private String userRole;


    public RoleDTO(Long roleId, String userRole) {
        this.roleId = roleId;
        this.userRole = userRole;
    }

    // Getters and Setters
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
