package io.helti.trainingservice.entities.templates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemplateSet {
	private Long id;
	private Long exerciseId;
	private byte sets;

	@Override
	public String toString() {
		return "TemplateSet{" +
				"id=" + id +
				", exerciseId=" + exerciseId +
				", sets=" + sets +
				'}';
	}
}
