package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
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



}
