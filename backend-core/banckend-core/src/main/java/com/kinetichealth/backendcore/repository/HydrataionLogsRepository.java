package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.HydrationLogs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HydrataionLogsRepository extends JpaRepository<HydrationLogs, UUID> {
}
