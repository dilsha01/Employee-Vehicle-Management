package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "bike_employee") // Ensure table name matches
public class BikeEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bike_employee_id") // Explicitly map the column name
    private Long bikeEmployeeId;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "contact_no", nullable = true)
    private String contactNo;

    @Column(name = "email", nullable = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true) // Ensure correct foreign key name
    private Role role;

    @ManyToOne
    @JoinColumn(name = "entered_by", nullable = true) // Ensure correct foreign key name
    private OtherEmployee enteredBy;

    @Column(name = "entered_date", nullable = true)
    private LocalDateTime enteredDate;



    // Getters
    public Long getBikeEmployeeId() {
        return bikeEmployeeId;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public OtherEmployee getEnteredBy() {
        return enteredBy;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    // Setters
    public void setBikeEmployeeId(Long bikeEmployeeId) {
        this.bikeEmployeeId = bikeEmployeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEnteredBy(OtherEmployee enteredBy) {
        this.enteredBy = enteredBy;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
