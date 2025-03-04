package com.company.motorcyclemanagement.repository;

import com.company.motorcyclemanagement.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    boolean existsByBranchName(String branchName);
}
