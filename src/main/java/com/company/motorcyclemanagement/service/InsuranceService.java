package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.InsuranceDTO;
import com.company.motorcyclemanagement.entity.Insurance;
import com.company.motorcyclemanagement.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public List<InsuranceDTO> getAllInsurances() {
        return insuranceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public InsuranceDTO getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(() -> new RuntimeException("Insurance not found"));
        return convertToDTO(insurance);
    }

    public InsuranceDTO createInsurance(InsuranceDTO insuranceDTO) {
        Insurance insurance = convertToEntity(insuranceDTO);
        insurance = insuranceRepository.save(insurance);
        return convertToDTO(insurance);
    }

    public InsuranceDTO updateInsurance(Long id, InsuranceDTO insuranceDTO) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(id);
        if (optionalInsurance.isEmpty()) {
            throw new RuntimeException("Insurance not found");
        }

        Insurance insurance = optionalInsurance.get();
        insurance.setAmount(insuranceDTO.getAmount());
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
        dto.setApprovedDate(insurance.getApprovedDate());
        return dto;
    }

    private Insurance convertToEntity(InsuranceDTO dto) {
        Insurance insurance = new Insurance();
        insurance.setAmount(dto.getAmount());
        insurance.setApprovedDate(dto.getApprovedDate());
        return insurance;
    }
}
