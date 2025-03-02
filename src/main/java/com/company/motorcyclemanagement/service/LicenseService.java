package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.LicenseDTO;
import com.company.motorcyclemanagement.entity.License;
import com.company.motorcyclemanagement.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicenseService {
    @Autowired
    private LicenseRepository licenseRepository;

    // Get all licenses
    public List<LicenseDTO> getAllLicenses() {
        return licenseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get license by ID
    public LicenseDTO getLicenseById(Long id) {
        License license = licenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("License not found"));
        return convertToDTO(license);
    }

    // Create a new license
    public LicenseDTO createLicense(LicenseDTO licenseDTO) {
        License license = convertToEntity(licenseDTO);
        license = licenseRepository.save(license);
        return convertToDTO(license);
    }

    // Update an existing license
    public LicenseDTO updateLicense(Long id, LicenseDTO licenseDTO) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if (optionalLicense.isEmpty()) {
            throw new RuntimeException("License not found");
        }

        License license = optionalLicense.get();
        license.setAmount(licenseDTO.getAmount());
        license.setApprovedDate(licenseDTO.getApprovedDate());

        license = licenseRepository.save(license);
        return convertToDTO(license);
    }

    // Delete a license
    public void deleteLicense(Long id) {
        if (!licenseRepository.existsById(id)) {
            throw new RuntimeException("License not found");
        }
        licenseRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private LicenseDTO convertToDTO(License license) {
        LicenseDTO dto = new LicenseDTO();
        dto.setLicenseId(license.getLicenseId());
        dto.setMotorcycleId(license.getMotorcycle().getMotorcycleId());
        dto.setAmount(license.getAmount());
        dto.setApprovedDate(license.getApprovedDate());
        return dto;
    }

    // Convert DTO to Entity
    private License convertToEntity(LicenseDTO dto) {
        License license = new License();
        license.setAmount(dto.getAmount());
        license.setApprovedDate(dto.getApprovedDate());
        return license;
    }
}
