package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MotorcycleAllowance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allowanceId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "providedBy", nullable = false)
    private OtherEmployee providedBy;

    private LocalDateTime providedDate;

    // Getters
    public Long getAllowanceId() { return allowanceId; }
    public MotorCycle getMotorcycle() { return motorcycle; }
    public Double getAmount() { return amount; }
    public Status getStatus() { return status; }
    public OtherEmployee getProvidedBy() { return providedBy; }
    public LocalDateTime getProvidedDate() { return providedDate; }

    // Setters
    public void setAllowanceId(Long allowanceId) { this.allowanceId = allowanceId; }
    public void setMotorcycle(MotorCycle motorcycle) { this.motorcycle = motorcycle; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setStatus(Status status) { this.status = status; }
    public void setProvidedBy(OtherEmployee providedBy) { this.providedBy = providedBy; }
    public void setProvidedDate(LocalDateTime providedDate) { this.providedDate = providedDate; }
}
