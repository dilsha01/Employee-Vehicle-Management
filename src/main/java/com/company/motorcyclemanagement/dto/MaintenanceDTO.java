package com.company.motorcyclemanagement.dto;

import java.time.LocalDateTime;

public class MaintenanceDTO {
    private Long maintenanceId;
    private Long motorcycleId;
    private LocalDateTime maintenanceDate;
    private Double amount;

    // Getter and Setter for maintenanceId
    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    // Getter and Setter for motorcycleId
    public Long getMotorcycleId() {
        return motorcycleId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
    }

    // Getter and Setter for maintenanceDate
    public LocalDateTime getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDateTime maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    // Getter and Setter for amount
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
