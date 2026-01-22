package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.HealthMetrics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HealthMetricsRepository extends JpaRepository<HealthMetrics, UUID> {
}
