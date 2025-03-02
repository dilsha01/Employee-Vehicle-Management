package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String userRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BikeEmployee> bikeEmployees;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OtherEmployee> otherEmployees;

    // Getters and Setters
    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }

    public Set<BikeEmployee> getBikeEmployees() { return bikeEmployees; }
    public void setBikeEmployees(Set<BikeEmployee> bikeEmployees) { this.bikeEmployees = bikeEmployees; }

    public Set<OtherEmployee> getOtherEmployees() { return otherEmployees; }
    public void setOtherEmployees(Set<OtherEmployee> otherEmployees) { this.otherEmployees = otherEmployees; }
}
