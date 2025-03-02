package com.company.motorcyclemanagement.repository;

import com.company.motorcyclemanagement.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {}
