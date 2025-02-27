package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    private String maintenanceDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters
}