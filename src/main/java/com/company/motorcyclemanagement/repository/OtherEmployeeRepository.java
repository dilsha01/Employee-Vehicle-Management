package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.OtherEmployee;

import java.util.Optional;

public interface OtherEmployeeRepository extends JpaRepository<OtherEmployee, Long> {
        Optional<OtherEmployee> findByName(String name);
}
