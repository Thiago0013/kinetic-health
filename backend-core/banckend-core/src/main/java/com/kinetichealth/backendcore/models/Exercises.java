package com.kinetichealth.backendcore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    @JsonIgnore
    private Workouts workout;


    @Column(nullable = false)
    private String exerciseName;

    private Integer sets;
    private Integer reps;
    private Integer durationSeconds;
    private Double weightKg;
}
