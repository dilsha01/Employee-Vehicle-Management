package com.company.motorcyclemanagement.dto;

import java.time.LocalDateTime;

public class RunningChartDTO {
    private Long runningChartId;
    private Long motorcycleId;
    private String startLocation;
    private String endLocation;
    private Double startOdometer;
    private Double endOdometer;
    private LocalDateTime date;

    // Getter and Setter for runningChartId
    public Long getRunningChartId() {
        return runningChartId;
    }

    public void setRunningChartId(Long runningChartId) {
        this.runningChartId = runningChartId;
    }

    // Getter and Setter for motorcycleId
    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    // Getter and Setter for startLocation
    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    // Getter and Setter for endLocation
    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    // Getter and Setter for startOdometer
    public Double getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(Double startOdometer) {
        this.startOdometer = startOdometer;
    }

    // Getter and Setter for endOdometer
    public Double getEndOdometer() {
        return endOdometer;
    }

    public void setEndOdometer(Double endOdometer) {
        this.endOdometer = endOdometer;
    }

    // Getter and Setter for date
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
