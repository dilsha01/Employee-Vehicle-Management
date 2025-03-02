package com.company.motorcyclemanagement.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MotorcycleDTO {
    private Long motorcycleId;
    private String registrationNo;
    private Double loanAmount;
    private String loanCompletionDate;
    private Long statusId;
    private Long bikeEmployeeId;
    private Long enteredById;
    private LocalDateTime enteredDate;

    // Getters
    public Long getMotorcycleId() { return motorcycleId; }
    public String getRegistrationNo() { return registrationNo; }
    public Double getLoanAmount() { return loanAmount; }
    public String getLoanCompletionDate() { return loanCompletionDate; }
    public Long getStatusId() { return statusId; }
    public Long getBikeEmployeeId() { return bikeEmployeeId; }
    public Long getEnteredById() { return enteredById; }
    public LocalDateTime getEnteredDate() { return enteredDate; }

    // Setters
    public void setMotorcycleId(Long motorcycleId) { this.motorcycleId = motorcycleId; }
    public void setRegistrationNo(String registrationNo) { this.registrationNo = registrationNo; }
    public void setLoanAmount(Double loanAmount) { this.loanAmount = loanAmount; }
    public void setLoanCompletionDate(String loanCompletionDate) { this.loanCompletionDate = loanCompletionDate; }
    public void setStatusId(Long statusId) { this.statusId = statusId; }
    public void setBikeEmployeeId(Long bikeEmployeeId) { this.bikeEmployeeId = bikeEmployeeId; }
    public void setEnteredById(Long enteredById) { this.enteredById = enteredById; }
    public void setEnteredDate(LocalDateTime enteredDate) { this.enteredDate = enteredDate; }
}