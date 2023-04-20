package io.helti.trainingservice.entities.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseSet {
	private Long id;
	private Long exerciseId;
	private Integer reps;
	private Integer weight;
	private Integer restTime;
	private Integer order;
	private String notes;
}
