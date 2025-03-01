package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RunningChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runningChartId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

    private String startLocation;
    private String endLocation;
    private Double startOdometer;
    private Double endOdometer;
    private LocalDateTime date; // Changed from String to LocalDateTime for better accuracy

    @ManyToOne
    @JoinColumn(name = "approvedBy", nullable = false)
    private OtherEmployee approvedBy;

    private LocalDateTime approvedDate;
}

