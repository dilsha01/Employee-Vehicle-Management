package com.company.motorcyclemanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BikeEmployeeDTO {
    private Long bikeEmployeeId;
    private String name;
    private String contactNo;
    private String email;
    private Long roleId; // Assuming you want to pass only the ID of Role
    private Long enteredById; // Assuming you want to pass only the ID of OtherEmployee
    private LocalDateTime enteredDate;

    // Getter and Setter for bikeEmployeeId
    public Long getBikeEmployeeId() {
        return bikeEmployeeId;
    }

    public void setBikeEmployeeId(Long bikeEmployeeId) {
        this.bikeEmployeeId = bikeEmployeeId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for contactNo
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for roleId
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    // Getter and Setter for enteredById
    public Long getEnteredById() {
        return enteredById;
    }

    public void setEnteredById(Long enteredById) {
        this.enteredById = enteredById;
    }

    // Getter and Setter for enteredDate
    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
