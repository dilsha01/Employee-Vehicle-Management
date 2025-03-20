package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.InsuranceDTO;
import com.company.motorcyclemanagement.entity.Insurance;
import com.company.motorcyclemanagement.entity.MotorCycle;
import com.company.motorcyclemanagement.entity.OtherEmployee;
import com.company.motorcyclemanagement.entity.Status;
import com.company.motorcyclemanagement.repository.InsuranceRepository;
import com.company.motorcyclemanagement.repository.MotorcycleRepository;
import com.company.motorcyclemanagement.repository.OtherEmployeeRepository;
import com.company.motorcyclemanagement.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private MotorcycleRepository motorCycleRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private OtherEmployeeRepository otherEmployeeRepository;

    public List<InsuranceDTO> getAllInsurances() {
        return insuranceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public InsuranceDTO getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
        return convertToDTO(insurance);
    }

    public InsuranceDTO createInsurance(InsuranceDTO insuranceDTO) {
        MotorCycle motorcycle = motorCycleRepository.findById(insuranceDTO.getMotorcycleId())
                .orElseThrow(() -> new RuntimeException("Motorcycle not found"));

        Status status = statusRepository.findById(insuranceDTO.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

        OtherEmployee approvedBy = otherEmployeeRepository.findById(insuranceDTO.getApprovedById())
                .orElseThrow(() -> new RuntimeException("Approving employee not found"));

        Insurance insurance = convertToEntity(insuranceDTO, motorcycle, status, approvedBy);
        insurance = insuranceRepository.save(insurance);
        return convertToDTO(insurance);
    }

    public InsuranceDTO updateInsurance(Long id, InsuranceDTO insuranceDTO) {
        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        MotorCycle motorcycle = motorCycleRepository.findById(insuranceDTO.getMotorcycleId())
                .orElseThrow(() -> new RuntimeException("Motorcycle not found"));

        Status status = statusRepository.findById(insuranceDTO.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

        OtherEmployee approvedBy = otherEmployeeRepository.findById(insuranceDTO.getApprovedById())
                .orElseThrow(() -> new RuntimeException("Approving employee not found"));

        insurance.setMotorcycle(motorcycle);
        insurance.setAmount(insuranceDTO.getAmount());

        insurance.setStatus(status);
        insurance.setApprovedBy(approvedBy);
        insurance.setApprovedDate(insuranceDTO.getApprovedDate());

        insurance = insuranceRepository.save(insurance);
        return convertToDTO(insurance);
    }

    public void deleteInsurance(Long id) {
        if (!insuranceRepository.existsById(id)) {
            throw new RuntimeException("Insurance not found");
        }
        insuranceRepository.deleteById(id);
    }

    private InsuranceDTO convertToDTO(Insurance insurance) {
        InsuranceDTO dto = new InsuranceDTO();
        dto.setInsuranceId(insurance.getInsuranceId());
        dto.setMotorcycleId(insurance.getMotorcycle().getMotorcycleId());
        dto.setAmount(insurance.getAmount());

        dto.setStatusId(insurance.getStatus().getStatusId());

        dto.setApprovedDate(insurance.getApprovedDate());
        return dto;
    }

    private Insurance convertToEntity(InsuranceDTO dto, MotorCycle motorcycle, Status status, OtherEmployee approvedBy) {
        Insurance insurance = new Insurance();
        insurance.setInsuranceId(dto.getInsuranceId()); // Set ID if needed for updates
        insurance.setMotorcycle(motorcycle);
        insurance.setAmount(dto.getAmount());

        insurance.setStatus(status);
        insurance.setApprovedBy(approvedBy);
        insurance.setApprovedDate(dto.getApprovedDate());
        return insurance;
    }
}
