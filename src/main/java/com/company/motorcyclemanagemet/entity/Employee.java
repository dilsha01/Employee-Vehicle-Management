package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String contactNo;
    private String email;

    @OneToOne
    @JoinColumn(name = "roleID")
    private Role role;
}