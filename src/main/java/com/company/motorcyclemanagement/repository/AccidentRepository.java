package com.company.motorcyclemanagement.repository;

import com.company.motorcyclemanagement.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {}