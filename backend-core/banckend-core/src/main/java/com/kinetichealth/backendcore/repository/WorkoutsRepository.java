package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutsRepository extends JpaRepository<Workouts, UUID> {
}
