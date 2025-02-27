package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String userRole;

    @OneToMany(mappedBy = "role")
    private Set<Employee> employees;

    // Getters and Setters
}
