package com.company.motorcyclemanagement.controller;

import com.company.motorcyclemanagement.dto.BranchDTO;
import com.company.motorcyclemanagement.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping
    public List<BranchDTO> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public BranchDTO getBranchById(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    @PostMapping
    public BranchDTO createBranch(@RequestBody BranchDTO branchDTO) {
        return branchService.createBranch(branchDTO);
    }

    @PutMapping("/{id}")
    public BranchDTO updateBranch(@PathVariable Long id, @RequestBody BranchDTO branchDTO) {
        return branchService.updateBranch(id, branchDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return "Branch deleted successfully";
    }
}
