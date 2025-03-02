package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BikeEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bikeEmployeeId;

    private String name;
    private String contactNo;
    private String email;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "enteredBy", nullable = false)
    private OtherEmployee enteredBy;

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
