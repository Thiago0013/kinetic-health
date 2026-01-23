package com.kinetichealth.backendcore.repository;

import com.kinetichealth.backendcore.models.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, UUID> {
}
