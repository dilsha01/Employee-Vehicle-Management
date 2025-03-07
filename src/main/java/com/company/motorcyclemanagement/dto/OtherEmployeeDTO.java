package com.company.motorcyclemanagement.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

public class OtherEmployeeDTO {
    private Long otherEmployeeId;
    private String name;
    private String contactNo;
    private String email;
    private String password;  // Added only if needed for user creation/update
    private Long roleId;
    private Long branchId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public LocalDateTime getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate) {
        this.enteredDate = enteredDate;
    }
}
