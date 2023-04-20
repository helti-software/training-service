package io.helti.trainingservice.dtos.workouts;

public record WorkoutSetDto(Long id, byte setNumber, byte reps, float weight) {
}
