package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.*;

@Entity
public class RunningChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runningChartId;

    private String startLocation;
    private String endLocation;
    private Double startOdometer;
    private Double endOdometer;
    private String date;

    @ManyToOne
    @JoinColumn(name = "motorcycleId")
    private MotorCycle motorcycle;

    // Getters and Setters
}
