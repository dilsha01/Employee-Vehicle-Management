package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented ID
    private Long insuranceId;

    @ManyToOne
    @JoinColumn(name = "motorcycle_id", nullable = false) // Matches DB column
    private MotorCycle motorcycle;

    private Double amount;


    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false) // Matches DB column
    private Status status;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false) // Matches DB column
    private OtherEmployee approvedBy;

    private LocalDateTime approvedDate;

    // Getters
    public Long getInsuranceId() { return insuranceId; }
    public MotorCycle getMotorcycle() { return motorcycle; }
    public Double getAmount() { return amount; }

    public Status getStatus() { return status; }
    public OtherEmployee getApprovedBy() { return approvedBy; }
    public LocalDateTime getApprovedDate() { return approvedDate; }

    // Setters
    public void setInsuranceId(Long insuranceId) { this.insuranceId = insuranceId; }
    public void setMotorcycle(MotorCycle motorcycle) { this.motorcycle = motorcycle; }
    public void setAmount(Double amount) { this.amount = amount; }

    public void setStatus(Status status) { this.status = status; }
    public void setApprovedBy(OtherEmployee approvedBy) { this.approvedBy = approvedBy; }
    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
}
