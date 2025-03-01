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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

    private Double amount;

    @Lob
    private byte[] documents; // To store PDF/JPEG files as BLOB

    @ManyToOne
    @JoinColumn(name = "approvedBy", nullable = false)
    private OtherEmployee approvedBy;

    private LocalDateTime approvedDate;
}
