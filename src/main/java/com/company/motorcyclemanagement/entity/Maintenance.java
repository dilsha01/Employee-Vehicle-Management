package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

    private LocalDateTime maintenanceDate;
    private Double amount;

    @Lob
    private byte[] documents; // To store PDF/JPEG files as BLOB

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "approvedBy", nullable = false)
    private OtherEmployee approvedBy;

    private LocalDateTime approvedDate;

    // Getters
    public Long getMaintenanceId() { return maintenanceId; }
    public MotorCycle getMotorcycle() { return motorcycle; }
    public LocalDateTime getMaintenanceDate() { return maintenanceDate; }
    public Double getAmount() { return amount; }
    public byte[] getDocuments() { return documents; }
    public Status getStatus() { return status; }
    public OtherEmployee getApprovedBy() { return approvedBy; }
    public LocalDateTime getApprovedDate() { return approvedDate; }

    // Setters
    public void setMaintenanceId(Long maintenanceId) { this.maintenanceId = maintenanceId; }
    public void setMotorcycle(MotorCycle motorcycle) { this.motorcycle = motorcycle; }
    public void setMaintenanceDate(LocalDateTime maintenanceDate) { this.maintenanceDate = maintenanceDate; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDocuments(byte[] documents) { this.documents = documents; }
    public void setStatus(Status status) { this.status = status; }
    public void setApprovedBy(OtherEmployee approvedBy) { this.approvedBy = approvedBy; }
    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
}
