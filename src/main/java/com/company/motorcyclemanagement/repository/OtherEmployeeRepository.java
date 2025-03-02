package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.OtherEmployee;

public interface OtherEmployeeRepository extends JpaRepository<OtherEmployee, Long> {
}
