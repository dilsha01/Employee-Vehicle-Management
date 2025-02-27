package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class MotorCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motorcycleId;

    private String registrationNo;
    private Double loanAmount;
    private String loanCompletionDate;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @OneToMany(mappedBy = "motorcycle")
    private Set<Accident> accidents;

    @OneToMany(mappedBy = "motorcycle")
    private Set<Maintenance> maintenances;

    @OneToMany(mappedBy = "motorcycle")
    private Set<License> licenses;

    @OneToMany(mappedBy = "motorcycle")
    private Set<Insurance> insurances;

    @OneToMany(mappedBy = "motorcycle")
    private Set<RunningChart> runningCharts;

    @OneToMany(mappedBy = "motorcycle")
    private Set<MotorcycleAllowance> allowances;

// Getters and Setters
}
