package com.kinetichealth.backendcore.dto;


import java.util.List;

public record WorkoutsDTO (
        String title,
        String workoutType,
        Integer durationMinutes,
        List<ExerciseDTO> exercises
) {
}
