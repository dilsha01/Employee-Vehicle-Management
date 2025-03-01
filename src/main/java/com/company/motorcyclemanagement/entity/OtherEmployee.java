package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class OtherEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otherEmployeeId;

    private String name;
    private String contactNo;
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "enteredBy", nullable = true)
    private OtherEmployee enteredBy;

    private LocalDateTime enteredDate;

    @OneToMany(mappedBy = "enteredBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OtherEmployee> enteredOtherEmployees;

    @OneToMany(mappedBy = "enteredBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BikeEmployee> enteredBikeEmployees;

    @OneToMany(mappedBy = "notedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Accident> notedAccidents;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Maintenance> approvedMaintenances;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Insurance> approvedInsurances;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<License> approvedLicenses;

    @OneToMany(mappedBy = "providedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MotorcycleAllowance> providedMotorcycleAllowances;

    @OneToMany(mappedBy = "approvedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RunningChart> approvedRunningCharts;
}
