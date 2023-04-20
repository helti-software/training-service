package io.helti.trainingservice.entities.templates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Template {
	private Long id;
	private String name;
	private List<TemplateSet> setsPerExercise;

	@Override
	public String toString() {
		return "Template{" +
				"id=" + id +
				", name='" + name + '\'' +
				", setsPerExercise=" + setsPerExercise +
				'}';
	}
}
