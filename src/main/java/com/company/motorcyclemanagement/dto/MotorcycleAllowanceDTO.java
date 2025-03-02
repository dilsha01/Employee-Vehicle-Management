package com.company.motorcyclemanagement.dto;

import java.time.LocalDateTime;

public class MotorcycleAllowanceDTO {
    private Long allowanceId;
    private Long motorcycleId;
    private Double amount;
    private LocalDateTime providedDate;

    // Getter and Setter for allowanceId
    public Long getAllowanceId() {
        return allowanceId;
    }

    public void setAllowanceId(Long allowanceId) {
        this.allowanceId = allowanceId;
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

    // Getter and Setter for providedDate
    public LocalDateTime getProvidedDate() {
        return providedDate;
    }

    public void setProvidedDate(LocalDateTime providedDate) {
        this.providedDate = providedDate;
    }
}
