package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.AccidentDTO;
import com.company.motorcyclemanagement.entity.Accident;
import com.company.motorcyclemanagement.entity.MotorCycle;
import com.company.motorcyclemanagement.entity.Status;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.repository.AccidentRepository;
import com.company.motorcyclemanagement.repository.MotorcycleRepository;
import com.company.motorcyclemanagement.repository.StatusRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;
    private final MotorcycleRepository motorCycleRepository;
    private final StatusRepository statusRepository;
    private final OtherEmployeeRepository otherEmployeeRepository;

    public AccidentService(
            AccidentRepository accidentRepository,
            MotorcycleRepository motorCycleRepository,
            StatusRepository statusRepository,
            OtherEmployeeRepository otherEmployeeRepository) {
        this.accidentRepository = accidentRepository;
        this.motorCycleRepository = motorCycleRepository;
        this.statusRepository = statusRepository;
        this.otherEmployeeRepository = otherEmployeeRepository;
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

    public AccidentDTO saveAccident(AccidentDTO accidentDTO) {
        Accident accident = convertToEntity(accidentDTO);
        return convertToDTO(accidentRepository.save(accident));
    }

    public AccidentDTO updateAccident(Long id, AccidentDTO accidentDTO) {
        Accident accident = accidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accident not found with ID: " + id));

        accident.setAccidentDate(accidentDTO.getAccidentDate());
        accident.setDescription(accidentDTO.getDescription());
//        accident.setDocuments(accidentDTO.getDocuments());

        if (accidentDTO.getMotorcycleId() != null) {
            MotorCycle motorcycle = motorCycleRepository.findById(accidentDTO.getMotorcycleId())
                    .orElseThrow(() -> new RuntimeException("Motorcycle not found"));
            accident.setMotorcycle(motorcycle);
        }

        if (accidentDTO.getStatusId() != null) {
            Status status = statusRepository.findById(accidentDTO.getStatusId())
                    .orElseThrow(() -> new RuntimeException("Status not found"));
            accident.setStatus(status);
        }

        if (accidentDTO.getNotedById() != null) {
            OtherEmployee notedBy = otherEmployeeRepository.findById(accidentDTO.getNotedById())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            accident.setNotedBy(notedBy);
        }

        accident.setNotedDate(accidentDTO.getNotedDate());

        return convertToDTO(accidentRepository.save(accident));
    }

    public void deleteAccident(Long id) {
        if (!accidentRepository.existsById(id)) {
            throw new RuntimeException("Accident not found with ID: " + id);
        }
        accidentRepository.deleteById(id);
    }

    private AccidentDTO convertToDTO(Accident accident) {
        AccidentDTO dto = new AccidentDTO();
        dto.setAccidentId(accident.getAccidentId());
        dto.setMotorcycleId(accident.getMotorcycle() != null ? accident.getMotorcycle().getMotorcycleId() : null);
        dto.setAccidentDate(accident.getAccidentDate());
        dto.setDescription(accident.getDescription());
//        dto.setDocuments(accident.getDocuments());
        dto.setStatusId(accident.getStatus() != null ? accident.getStatus().getStatusId() : null);
        dto.setNotedById(accident.getNotedBy() != null ? accident.getNotedBy().getOtherEmployeeId() : null);
        dto.setNotedDate(accident.getNotedDate());
        return dto;
    }

    private Accident convertToEntity(AccidentDTO dto) {
        Accident accident = new Accident();
        accident.setAccidentDate(dto.getAccidentDate());
        accident.setDescription(dto.getDescription());
//        accident.setDocuments(dto.getDocuments());
        return accident;
    }
}
