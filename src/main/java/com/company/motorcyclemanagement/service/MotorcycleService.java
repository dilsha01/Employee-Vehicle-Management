package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.MotorcycleDTO;
import com.company.motorcyclemanagement.entity.MotorCycle;
import com.company.motorcyclemanagement.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorcycleService {
    @Autowired
    private MotorcycleRepository motorcycleRepository;

    public List<MotorcycleDTO> getAllMotorcycles() {
        return motorcycleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MotorcycleDTO getMotorcycleById(Long id) {
        return motorcycleRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public MotorCycle saveMotorcycle(MotorCycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteMotorcycle(Long id) {
        motorcycleRepository.deleteById(id);
    }

    private MotorcycleDTO convertToDTO(MotorCycle motorcycle) {
        MotorcycleDTO dto = new MotorcycleDTO();
        dto.setMotorcycleId(motorcycle.getMotorcycleId());
        dto.setRegistrationNo(motorcycle.getRegistrationNo());
        dto.setLoanAmount(motorcycle.getLoanAmount());
        dto.setLoanCompletionDate(motorcycle.getLoanCompletionDate());
        dto.setStatusId(motorcycle.getStatus().getStatusId());
        dto.setBikeEmployeeId(motorcycle.getEmployee().getBikeEmployeeId());
        dto.setEnteredById(motorcycle.getEnteredBy().getOtherEmployeeId());
        dto.setEnteredDate(motorcycle.getEnteredDate());
        return dto;
    }
}
