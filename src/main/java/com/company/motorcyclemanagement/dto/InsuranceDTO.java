package com.company.motorcyclemanagement.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class InsuranceDTO {
    private Long insuranceId;
    private Long motorcycleId;
    private Double amount;
    private byte[] documents; // To store PDF/JPEG files as BLOB
    private Long statusId;
    private Long approvedById;
    private LocalDateTime approvedDate;

    // Getter and Setter for insuranceId
    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    // Getter and Setter for motorcycleId
    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    // Getter and Setter for amount
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // Getter and Setter for documents
    public byte[] getDocuments() {
        return documents;
    }

    public void setDocuments(byte[] documents) {
        this.documents = documents;
    }

    // Getter and Setter for statusId
    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    // Getter and Setter for approvedById
    public Long getApprovedById() {
        return approvedById;
    }

    public void setApprovedById(Long approvedById) {
        this.approvedById = approvedById;
    }

    // Getter and Setter for approvedDate
    public LocalDateTime getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDateTime approvedDate) {
        this.approvedDate = approvedDate;
    }
}
