package com.kinetichealth.backendcore.dto;

public record ExerciseDTO (
        String exerciseName,
        Integer sets,
        Integer reps,
        Integer durationSeconds,
        Double weightKg
){
}
