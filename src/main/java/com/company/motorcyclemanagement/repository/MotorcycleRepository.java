package com.company.motorcyclemanagement.repository;

import com.company.motorcyclemanagement.entity.MotorCycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<MotorCycle, Long> {}