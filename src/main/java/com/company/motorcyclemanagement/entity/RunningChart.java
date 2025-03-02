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
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "approvedBy", nullable = false)
    private OtherEmployee approvedBy;

    private LocalDateTime approvedDate;

    // Getters and Setters
    public Long getRunningChartId() { return runningChartId; }
    public void setRunningChartId(Long runningChartId) { this.runningChartId = runningChartId; }

    public MotorCycle getMotorcycle() { return motorcycle; }
    public void setMotorcycle(MotorCycle motorcycle) { this.motorcycle = motorcycle; }

    public String getStartLocation() { return startLocation; }
    public void setStartLocation(String startLocation) { this.startLocation = startLocation; }

    public String getEndLocation() { return endLocation; }
    public void setEndLocation(String endLocation) { this.endLocation = endLocation; }

    public Double getStartOdometer() { return startOdometer; }
    public void setStartOdometer(Double startOdometer) { this.startOdometer = startOdometer; }

    public Double getEndOdometer() { return endOdometer; }
    public void setEndOdometer(Double endOdometer) { this.endOdometer = endOdometer; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public OtherEmployee getApprovedBy() { return approvedBy; }
    public void setApprovedBy(OtherEmployee approvedBy) { this.approvedBy = approvedBy; }

    public LocalDateTime getApprovedDate() { return approvedDate; }
    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
}

