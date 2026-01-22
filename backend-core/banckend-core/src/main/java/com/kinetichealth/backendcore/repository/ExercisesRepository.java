package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercisesRepository extends JpaRepository<Exercises, UUID> {
}
