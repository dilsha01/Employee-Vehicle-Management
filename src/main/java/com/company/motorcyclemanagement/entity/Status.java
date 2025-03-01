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

}
