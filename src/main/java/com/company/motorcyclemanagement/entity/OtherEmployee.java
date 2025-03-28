package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.FileDescriptor;
import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch; // Each employee has ONE branch

    @ManyToOne
    @JoinColumn(name = "enteredBy", nullable = true)
    private OtherEmployee enteredBy;

    private LocalDateTime enteredDate;

   // public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    public void setPassword(String password) {
//        this.password = passwordEncoder.encode(password);
//        System.out.println("Password: " + this.password);
//    }

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

    // Getters and Setters
    public Long getOtherEmployeeId() { return otherEmployeeId; }
    public void setOtherEmployeeId(Long otherEmployeeId) { this.otherEmployeeId = otherEmployeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public OtherEmployee getEnteredBy() { return enteredBy; }
    public void setEnteredBy(OtherEmployee enteredBy) { this.enteredBy = enteredBy; }

    public LocalDateTime getEnteredDate() { return enteredDate; }
    public void setEnteredDate(LocalDateTime enteredDate) { this.enteredDate = enteredDate; }

    public Set<OtherEmployee> getEnteredOtherEmployees() { return enteredOtherEmployees; }
    public void setEnteredOtherEmployees(Set<OtherEmployee> enteredOtherEmployees) { this.enteredOtherEmployees = enteredOtherEmployees; }

    public Set<BikeEmployee> getEnteredBikeEmployees() { return enteredBikeEmployees; }
    public void setEnteredBikeEmployees(Set<BikeEmployee> enteredBikeEmployees) { this.enteredBikeEmployees = enteredBikeEmployees; }

    public Set<Accident> getNotedAccidents() { return notedAccidents; }
    public void setNotedAccidents(Set<Accident> notedAccidents) { this.notedAccidents = notedAccidents; }

    public Set<Maintenance> getApprovedMaintenances() { return approvedMaintenances; }
    public void setApprovedMaintenances(Set<Maintenance> approvedMaintenances) { this.approvedMaintenances = approvedMaintenances; }

    public Set<Insurance> getApprovedInsurances() { return approvedInsurances; }
    public void setApprovedInsurances(Set<Insurance> approvedInsurances) { this.approvedInsurances = approvedInsurances; }

    public Set<License> getApprovedLicenses() { return approvedLicenses; }
    public void setApprovedLicenses(Set<License> approvedLicenses) { this.approvedLicenses = approvedLicenses; }

    public Set<MotorcycleAllowance> getProvidedMotorcycleAllowances() { return providedMotorcycleAllowances; }
    public void setProvidedMotorcycleAllowances(Set<MotorcycleAllowance> providedMotorcycleAllowances) { this.providedMotorcycleAllowances = providedMotorcycleAllowances; }

    public Set<RunningChart> getApprovedRunningCharts() { return approvedRunningCharts; }
    public void setApprovedRunningCharts(Set<RunningChart> approvedRunningCharts) { this.approvedRunningCharts = approvedRunningCharts; }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password; // Password encoding is done in the service layer
    }
}
