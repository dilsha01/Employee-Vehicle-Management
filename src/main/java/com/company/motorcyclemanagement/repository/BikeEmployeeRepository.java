package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.BikeEmployee;

public interface BikeEmployeeRepository extends JpaRepository<BikeEmployee, Long> {
}
