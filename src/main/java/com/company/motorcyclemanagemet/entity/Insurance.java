package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters
}