package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkoutsRepository extends JpaRepository<Workouts, UUID> {
}
