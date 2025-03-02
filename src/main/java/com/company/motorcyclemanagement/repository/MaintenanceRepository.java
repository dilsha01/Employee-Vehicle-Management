package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
