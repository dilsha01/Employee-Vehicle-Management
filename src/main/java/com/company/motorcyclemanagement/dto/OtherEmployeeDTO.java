package com.company.motorcyclemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class OtherEmployeeDTO {
    private Long otherEmployeeId;
    private String name;
    private String contactNo;
    private String email;
    private Long roleId;
    private LocalDateTime enteredDate;

    // Getters and Setters
    public Long getOtherEmployeeId() {
        return otherEmployeeId;
    }

    public void setOtherEmployeeId(Long otherEmployeeId) {
        this.otherEmployeeId = otherEmployeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
