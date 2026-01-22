package com.kinetichealth.backendcore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "health_metrics")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private Double caloriesBurned;

    @Column(nullable = false)
    private LocalDateTime metricDate;
}
