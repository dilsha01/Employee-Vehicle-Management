package com.company.motorcyclemanagemet.entity;

import com.company.motorcyclemanagemet.entity.MotorCycle;
import jakarta.persistence.*;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters

}
