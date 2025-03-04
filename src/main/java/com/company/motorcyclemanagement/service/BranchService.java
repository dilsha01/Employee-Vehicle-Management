package com.company.motorcyclemanagement.service;

import com.company.motorcyclemanagement.dto.BranchDTO;
import com.company.motorcyclemanagement.entity.Branch;
import com.company.motorcyclemanagement.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BranchDTO getBranchById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        return convertToDTO(branch);
    }

    public BranchDTO createBranch(BranchDTO branchDTO) {
        if (branchRepository.existsByBranchName(branchDTO.getBranchName())) {
            throw new RuntimeException("Branch name already exists");
        }
        Branch branch = convertToEntity(branchDTO);
        branch = branchRepository.save(branch);
        return convertToDTO(branch);
    }

    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setBranchName(branchDTO.getBranchName());
        branch = branchRepository.save(branch);
        return convertToDTO(branch);
    }

    public void deleteBranch(Long id) {
        if (!branchRepository.existsById(id)) {
            throw new RuntimeException("Branch not found");
        }
        branchRepository.deleteById(id);
    }

    // DTO Converters
    private BranchDTO convertToDTO(Branch branch) {
        BranchDTO dto = new BranchDTO();
        dto.setBranchId(branch.getBranchId());
        dto.setBranchName(branch.getBranchName());
        return dto;
    }

    private Branch convertToEntity(BranchDTO dto) {
        Branch branch = new Branch();
        branch.setBranchName(dto.getBranchName());
        return branch;
    }
}
