package io.helti.trainingservice.dtos.templates;

import java.util.List;

public record TemplateCreationDto(String name, List<TemplateSetsDto> exercisesSets) {
}
