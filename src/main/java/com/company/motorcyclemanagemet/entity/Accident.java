package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

@Entity
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accidentId;

    private String accidentDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters
}