package io.helti.trainingservice.entities.workouts;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Workout {
	private Long id;

	private String name;

	private List<WorkoutSet> sets;

	private LocalDateTime startTime;
	private LocalDateTime endTime;
}
