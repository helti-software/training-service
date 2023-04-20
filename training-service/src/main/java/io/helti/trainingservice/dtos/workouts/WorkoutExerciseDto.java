package io.helti.trainingservice.dtos.workouts;

import java.util.List;

public record WorkoutExerciseDto(Long exerciseId, String name, List<WorkoutSetDto> sets) {
}
