package com.company.motorcyclemanagement.dto;

import java.time.LocalDateTime;

public class AccidentDTO {
    private Long accidentId;
    private Long motorcycleId;
    private LocalDateTime accidentDate;
    private String description;
    private byte[] documents;
    private Long statusId;
    private Long notedById;
    private LocalDateTime notedDate;

    // Getters
    public Long getAccidentId() {
        return accidentId;
    }

    public Long getMotorcycleId() {
        return motorcycleId;
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

    public Long getStatusId() {
        return statusId;
    }

    public Long getNotedById() {
        return notedById;
    }

    public LocalDateTime getNotedDate() {
        return notedDate;
    }

    // Setters
    public void setAccidentId(Long accidentId) {
        this.accidentId = accidentId;
    }

    public void setMotorcycleId(Long motorcycleId) {
        this.motorcycleId = motorcycleId;
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

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setNotedById(Long notedById) {
        this.notedById = notedById;
    }

    public void setNotedDate(LocalDateTime notedDate) {
        this.notedDate = notedDate;
    }
}
