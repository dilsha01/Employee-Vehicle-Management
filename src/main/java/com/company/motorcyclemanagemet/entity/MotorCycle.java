package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MotorCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motorcycleId;
    private String registrationNo;
    private Double loanAmount;
    private String loanCompletionDate;
}

