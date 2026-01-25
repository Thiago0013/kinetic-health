package com.kinetichealth.backendcore.services;

import com.kinetichealth.backendcore.dto.WorkoutsDTO;
import com.kinetichealth.backendcore.models.Exercises;
import com.kinetichealth.backendcore.models.Users;
import com.kinetichealth.backendcore.models.Workouts;
import com.kinetichealth.backendcore.repository.ExercisesRepository;
import com.kinetichealth.backendcore.repository.WorkoutsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutsRepository workoutsRepo;

    public WorkoutService(WorkoutsRepository workoutsRepo){
        this.workoutsRepo = workoutsRepo;
    }

    public List<Workouts> getAll(Users user){
        return workoutsRepo.findAllByUser(user);

    }

    @Transactional
    public Workouts createWorkout (WorkoutsDTO dto, Users user){
        Workouts newWorkouts = Workouts.builder()
                .user(user)
                .workoutType(dto.workoutType())
                .title(dto.title())
                .workoutDate(LocalDateTime.now())
                .durationMinutes(dto.durationMinutes())
                .build();


        List<Exercises> exercises = dto.exercises().stream().map( e ->
                Exercises.builder()
                        .workout(newWorkouts)
                        .sets(e.sets())
                        .reps(e.reps())
                        .durationSeconds(e.durationSeconds())
                        .weightKg(e.weightKg())
                        .exerciseName(e.exerciseName())
                        .build()
        ).toList();

        newWorkouts.setExercises(exercises);

        return workoutsRepo.save(newWorkouts);
    }
}
