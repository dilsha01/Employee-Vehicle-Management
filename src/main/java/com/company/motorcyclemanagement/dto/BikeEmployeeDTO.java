package com.company.motorcyclemanagement.dto;

public class BikeEmployeeDTO {
    private Long bikeEmployeeId;
    private String name;
    private String contactNo;
    private String email;

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
}
