package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "motorcycle")
public class MotorCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motorcycleId;

    @OneToOne
    @JoinColumn(name = "bikeEmployeeId", nullable = false)
    private BikeEmployee employee;

    private String registrationNo;
    private Double loanAmount;
    private String loanCompletionDate;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "enteredBy", nullable = false)
    private OtherEmployee enteredBy;

    private LocalDateTime enteredDate;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Accident> accidents;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Maintenance> maintenances;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Insurance> insurances;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<License> licenses;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MotorcycleAllowance> motorcycleAllowances;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RunningChart> runningCharts;

    // Getters
    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public BikeEmployee getEmployee() {
        return employee;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public String getLoanCompletionDate() {
        return loanCompletionDate;
    }

    public Status getStatus() {
        return status;
    }

    public OtherEmployee getEnteredBy() {
        return enteredBy;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public Set<Accident> getAccidents() {
        return accidents;
    }

    public Set<Maintenance> getMaintenances() {
        return maintenances;
    }

    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public Set<License> getLicenses() {
        return licenses;
    }

    public Set<MotorcycleAllowance> getMotorcycleAllowances() {
        return motorcycleAllowances;
    }

    public Set<RunningChart> getRunningCharts() {
        return runningCharts;
    }

    // Setters
    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    public void setEmployee(BikeEmployee employee) {
        this.employee = employee;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanCompletionDate(String loanCompletionDate) {
        this.loanCompletionDate = loanCompletionDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEnteredBy(OtherEmployee enteredBy) {
        this.enteredBy = enteredBy;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }

    public void setAccidents(Set<Accident> accidents) {
        this.accidents = accidents;
    }

    public void setMaintenances(Set<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }

    public void setMotorcycleAllowances(Set<MotorcycleAllowance> motorcycleAllowances) {
        this.motorcycleAllowances = motorcycleAllowances;
    }

    public void setRunningCharts(Set<RunningChart> runningCharts) {
        this.runningCharts = runningCharts;
    }

}
