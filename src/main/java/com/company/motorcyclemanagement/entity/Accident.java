package com.company.motorcyclemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accidentId;

    @ManyToOne
    @JoinColumn(name = "motorcycleId", nullable = false)
    private MotorCycle motorcycle;

    private LocalDateTime accidentDate;
    private String description;

    @Lob
    private byte[] documents;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "notedBy", nullable = false)
    private OtherEmployee notedBy;

    private LocalDateTime notedDate;

    // Getters
    public Long getAccidentId() {
        return accidentId;
    }

    public MotorCycle getMotorcycle() {
        return motorcycle;
    }

    public LocalDateTime getAccidentDate() {
        return accidentDate;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getDocuments() {
        return documents;
    }

    public Status getStatus() {
        return status;
    }

    public OtherEmployee getNotedBy() {
        return notedBy;
    }

    public LocalDateTime getNotedDate() {
        return notedDate;
    }

    // Setters
    public void setAccidentId(Long accidentId) {
        this.accidentId = accidentId;
    }

    public void setMotorcycle(MotorCycle motorcycle) {
        this.motorcycle = motorcycle;
    }

    public void setAccidentDate(LocalDateTime accidentDate) {
        this.accidentDate = accidentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDocuments(byte[] documents) {
        this.documents = documents;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setNotedBy(OtherEmployee notedBy) {
        this.notedBy = notedBy;
    }

    public void setNotedDate(LocalDateTime notedDate) {
        this.notedDate = notedDate;
    }
}
