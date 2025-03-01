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
    @JoinColumn(name = "providedBy", nullable = false)
    private OtherEmployee providedBy;

    private LocalDateTime providedDate;
}
