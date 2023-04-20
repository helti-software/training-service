package io.helti.trainingservice.entities.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	private Long id;
	private String name;
	private String description;
	private List<String> equipment;
	private List<String> muscleGroups;

	@Override
	public String toString() {
		return "Exercise{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", equipment=" + equipment +
				", muscleGroups=" + muscleGroups +
				'}';
	}

	// TODO: Add more video and image

}
