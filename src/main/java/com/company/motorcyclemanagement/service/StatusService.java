package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.StatusDTO;
import com.company.motorcyclemanagement.entity.Status;
import com.company.motorcyclemanagement.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<StatusDTO> getAllStatuses() {
        return statusRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StatusDTO getStatusById(Long id) {
        return statusRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Status not found"));
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    public void deleteStatus(Long id) {
        if (!statusRepository.existsById(id)) {
            throw new RuntimeException("Status not found");
        }
        statusRepository.deleteById(id);
    }

    private StatusDTO convertToDTO(Status status) {
        StatusDTO dto = new StatusDTO();
        dto.setStatusId(status.getStatusId());
        dto.setStatus(status.getStatus());
        return dto;
    }
}
