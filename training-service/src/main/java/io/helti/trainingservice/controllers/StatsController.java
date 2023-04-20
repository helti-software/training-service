package io.helti.trainingservice.controllers;

import io.helti.trainingservice.services.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@AllArgsConstructor
public class StatsController {
	private final TrainingService trainingService;
}
