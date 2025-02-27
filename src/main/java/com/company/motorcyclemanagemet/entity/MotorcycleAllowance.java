package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

@Entity
public class MotorcycleAllowance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allowanceId;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters
}
