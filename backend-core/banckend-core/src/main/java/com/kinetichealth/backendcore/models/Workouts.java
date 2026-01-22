package com.kinetichealth.backendcore.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workouts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String title;

    private String workoutType;
    private Integer durationMinutes;

    @Column(nullable = false)
    private LocalDateTime workoutDate;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercises> exercises;
}
