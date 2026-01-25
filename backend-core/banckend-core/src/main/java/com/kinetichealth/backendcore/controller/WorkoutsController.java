package com.kinetichealth.backendcore.controller;

import com.kinetichealth.backendcore.dto.WorkoutsDTO;
import com.kinetichealth.backendcore.models.Users;
import com.kinetichealth.backendcore.models.Workouts;
import com.kinetichealth.backendcore.services.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutsController {
    private final WorkoutService workoutService;

    public WorkoutsController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workouts>> getall (@AuthenticationPrincipal Users user){
        return ResponseEntity.ok(workoutService.getAll(user));
    }

    @PostMapping
    public ResponseEntity<Void> createWorkout(@RequestBody WorkoutsDTO dto, @AuthenticationPrincipal Users user){
        workoutService.createWorkout(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
