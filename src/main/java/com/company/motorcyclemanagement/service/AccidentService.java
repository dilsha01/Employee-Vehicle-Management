package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.AccidentDTO;
import com.company.motorcyclemanagement.entity.Accident;
import com.company.motorcyclemanagement.repository.AccidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;

    public AccidentService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public List<AccidentDTO> getAllAccidents() {
        return accidentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccidentDTO getAccidentById(Long id) {
        return accidentRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Accident not found with ID: " + id));
    }

    public Accident saveAccident(Accident accident) {
        return accidentRepository.save(accident);
    }

    public void deleteAccident(Long id) {
        if (!accidentRepository.existsById(id)) {
            throw new RuntimeException("Accident not found with ID: " + id);
        }
        accidentRepository.deleteById(id);
    }

    public AccidentDTO convertToDTO(Accident accident) {
        AccidentDTO dto = new AccidentDTO();
        dto.setAccidentId(accident.getAccidentId());
        dto.setMotorcycleId(accident.getMotorcycle() != null ? accident.getMotorcycle().getMotorcycleId() : null);
        dto.setAccidentDate(accident.getAccidentDate());
        dto.setDescription(accident.getDescription());
        dto.setDocuments(accident.getDocuments());
        dto.setStatusId(accident.getStatus() != null ? accident.getStatus().getStatusId() : null);
        dto.setNotedById(accident.getNotedBy() != null ? accident.getNotedBy().getOtherEmployeeId() : null);
        dto.setNotedDate(accident.getNotedDate());
        return dto;
    }

}
