package io.helti.trainingservice.dtos.workouts;

import java.time.LocalDateTime;
import java.util.List;

public record WorkoutDetailsDto(Long id, String name, List<WorkoutExerciseDto> exercises, String length, double volume) {
}
