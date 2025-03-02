package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private String status;

    @OneToMany(mappedBy = "status")
    private Set<Accident> accidents;

    @OneToMany(mappedBy = "status")
    private Set<Insurance> insurances;

    @OneToMany(mappedBy = "status")
    private Set<License> licences;

    @OneToMany(mappedBy = "status")
    private Set<Maintenance> maintenances;

    @OneToMany(mappedBy = "status")
    private Set<MotorCycle> motorcycles;

    @OneToMany(mappedBy = "status")
    private Set<MotorcycleAllowance> motorcycleAllowances;

    @OneToMany(mappedBy = "status")
    private Set<RunningChart> runningCharts;

    // Getter and Setter for statusId
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for accidents
    public Set<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Set<Accident> accidents) {
        this.accidents = accidents;
    }

    // Getter and Setter for insurances
    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    // Getter and Setter for licences
    public Set<License> getLicences() {
        return licences;
    }

    public void setLicences(Set<License> licences) {
        this.licences = licences;
    }

    // Getter and Setter for maintenances
    public Set<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(Set<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    // Getter and Setter for motorcycles
    public Set<MotorCycle> getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(Set<MotorCycle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    // Getter and Setter for motorcycleAllowances
    public Set<MotorcycleAllowance> getMotorcycleAllowances() {
        return motorcycleAllowances;
    }

    public void setMotorcycleAllowances(Set<MotorcycleAllowance> motorcycleAllowances) {
        this.motorcycleAllowances = motorcycleAllowances;
    }

    // Getter and Setter for runningCharts
    public Set<RunningChart> getRunningCharts() {
        return runningCharts;
    }

    public void setRunningCharts(Set<RunningChart> runningCharts) {
        this.runningCharts = runningCharts;
    }
}
