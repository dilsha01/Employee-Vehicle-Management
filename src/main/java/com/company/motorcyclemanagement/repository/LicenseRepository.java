package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
