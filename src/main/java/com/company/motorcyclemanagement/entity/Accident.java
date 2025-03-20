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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorcycle_id", nullable = true)
    private MotorCycle motorcycle;

    @Column(nullable = true)
    private LocalDateTime accidentDate;

    @Column(length = 1000)
    private String description;

//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    private byte[] documents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noted_by", nullable = true)
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

//    public byte[] getDocuments() {
//        return documents;
//    }

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

//    public void setDocuments(byte[] documents) {
//        this.documents = documents;
//    }

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
