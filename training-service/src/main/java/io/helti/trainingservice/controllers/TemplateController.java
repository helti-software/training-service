package io.helti.trainingservice.controllers;

import io.helti.trainingservice.dtos.templates.TemplateCreationDto;
import io.helti.trainingservice.entities.templates.Template;
import io.helti.trainingservice.services.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class TemplateController {
	private final TrainingService trainingService;

	// Templates
	@GetMapping("/templates/{id}")
	public Template getTemplate(@PathVariable Long id) {
		log.info("Getting template with id: " + id);
		Template template = trainingService.getTemplate(id);
		log.info("Got template: " + template);
		return template;
	}

	@GetMapping("/templates")
	public List<Template> getTemplates() {
		log.info("Getting templates");
		return trainingService.getTemplatesList();
	}

	@PostMapping("/templates")
	public Template createTemplate(@RequestBody TemplateCreationDto template) {
		log.info("New template: " + template);
		Template newTemplate = trainingService.createTemplate(template);
		log.info("Created template: " + newTemplate);
		return newTemplate;
	}
}
