package com.company.motorcyclemanagemet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
