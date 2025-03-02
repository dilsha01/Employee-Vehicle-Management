package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
