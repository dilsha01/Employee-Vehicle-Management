package com.company.motorcyclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.company.motorcyclemanagement.entity.RunningChart;

public interface RunningChartRepository extends JpaRepository<RunningChart, Long> {
}
