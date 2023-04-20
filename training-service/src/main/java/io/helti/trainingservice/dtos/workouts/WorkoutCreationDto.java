package io.helti.trainingservice.dtos.workouts;

import java.util.List;

public record WorkoutCreationDto(String name, List<WorkoutSetDto> sets) {
}
