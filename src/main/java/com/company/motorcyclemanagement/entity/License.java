package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

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
    public Long getLicenseId() { return licenseId; }
    public MotorCycle getMotorcycle() { return motorcycle; }
    public Double getAmount() { return amount; }
    public byte[] getDocuments() { return documents; }
    public Status getStatus() { return status; }
    public OtherEmployee getApprovedBy() { return approvedBy; }
    public LocalDateTime getApprovedDate() { return approvedDate; }

    // Setters
    public void setLicenseId(Long licenseId) { this.licenseId = licenseId; }
    public void setMotorcycle(MotorCycle motorcycle) { this.motorcycle = motorcycle; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDocuments(byte[] documents) { this.documents = documents; }
    public void setStatus(Status status) { this.status = status; }
    public void setApprovedBy(OtherEmployee approvedBy) { this.approvedBy = approvedBy; }
    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
}
