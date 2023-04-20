package io.helti.trainingservice.entities.workouts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSet {
	private Long id;
	private Long exerciseId;
	private byte setNumber;
	private byte reps;
	private float weight;
	private boolean isCompleted;

	@Override
	public String toString() {
		return "WorkoutSet{" +
				"id=" + id +
				", exerciseId=" + exerciseId +
				", setNumber=" + setNumber +
				", reps=" + reps +
				", weight=" + weight +
				", isCompleted=" + isCompleted +
				'}';
	}
}
