package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.MotorcycleDTO;
import com.company.motorcyclemanagement.entity.MotorCycle;
import com.company.motorcyclemanagement.entity.Status;
import com.company.motorcyclemanagement.entity.BikeEmployee;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.repository.MotorcycleRepository;
import com.company.motorcyclemanagement.repository.StatusRepository;
import com.company.motorcyclemanagement.repository.BikeEmployeeRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorcycleService {
    @Autowired
    private MotorcycleRepository motorcycleRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private BikeEmployeeRepository bikeEmployeeRepository;
    @Autowired
    private OtherEmployeeRepository otherEmployeeRepository;

    public List<MotorcycleDTO> getAllMotorcycles() {
        return motorcycleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MotorcycleDTO getMotorcycleById(Long id) {
        return motorcycleRepository.findById(id).map(this::convertToDTO).orElseThrow(() -> new EntityNotFoundException("Motorcycle not found"));
    }

    @Transactional
    public MotorcycleDTO createMotorcycle(MotorcycleDTO motorcycleDTO) {
        MotorCycle motorcycle = new MotorCycle();
        motorcycle.setRegistrationNo(motorcycleDTO.getRegistrationNo());
        motorcycle.setLoanAmount(motorcycleDTO.getLoanAmount());
        motorcycle.setLoanCompletionDate(motorcycleDTO.getLoanCompletionDate());

        Status status = statusRepository.findById(motorcycleDTO.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
        motorcycle.setStatus(status);

        BikeEmployee employee = bikeEmployeeRepository.findById(motorcycleDTO.getBikeEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Bike Employee not found"));
        motorcycle.setEmployee(employee);

        OtherEmployee enteredBy = otherEmployeeRepository.findById(motorcycleDTO.getEnteredById())
                .orElseThrow(() -> new EntityNotFoundException("Entered By Employee not found"));
        motorcycle.setEnteredBy(enteredBy);

        motorcycle.setEnteredDate(motorcycleDTO.getEnteredDate());

        motorcycle = motorcycleRepository.save(motorcycle);
        return convertToDTO(motorcycle);
    }

    @Transactional
    public MotorcycleDTO updateMotorcycle(Long id, MotorcycleDTO motorcycleDTO) {
        MotorCycle motorcycle = motorcycleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Motorcycle not found"));

        motorcycle.setRegistrationNo(motorcycleDTO.getRegistrationNo());
        motorcycle.setLoanAmount(motorcycleDTO.getLoanAmount());
        motorcycle.setLoanCompletionDate(motorcycleDTO.getLoanCompletionDate());

        Status status = statusRepository.findById(motorcycleDTO.getStatusId())
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
        motorcycle.setStatus(status);

        BikeEmployee employee = bikeEmployeeRepository.findById(motorcycleDTO.getBikeEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Bike Employee not found"));
        motorcycle.setEmployee(employee);

        OtherEmployee enteredBy = otherEmployeeRepository.findById(motorcycleDTO.getEnteredById())
                .orElseThrow(() -> new EntityNotFoundException("Entered By Employee not found"));
        motorcycle.setEnteredBy(enteredBy);

        motorcycle.setEnteredDate(motorcycleDTO.getEnteredDate());

        motorcycle = motorcycleRepository.save(motorcycle);
        return convertToDTO(motorcycle);
    }

    @Transactional
    public void deleteMotorcycle(Long id) {
        if (!motorcycleRepository.existsById(id)) {
            throw new EntityNotFoundException("Motorcycle not found");
        }
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