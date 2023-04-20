package io.helti.trainingservice.dtos.exercises;

import java.util.List;

public record ExerciseCreationDto(String name, String description, List<String> equipment, List<String> muscleGroups) {
}
