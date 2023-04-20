package io.helti.trainingservice.controllers;

import io.helti.trainingservice.dtos.exercises.ExerciseCreationDto;
import io.helti.trainingservice.entities.exercises.Exercise;
import io.helti.trainingservice.services.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class ExerciseController {
	private final TrainingService trainingService;

	// Exercises
	@GetMapping("/exercises/{id}")
	public Exercise createExercise(@PathVariable Long id) {
		log.info("Getting exercise with id: " + id);
		Exercise exercise = trainingService.getExercise(id);
		log.info("Got exercise: " + exercise);
		return exercise;
	}

	@GetMapping("/exercises")
	public List<Exercise> getExercises() {
		List<Exercise> exercises = trainingService.getExerciseList();
		log.info("Got exercises: " + exercises);
		return exercises;
	}

	@PostMapping("/exercises")
	public Exercise createExercise(@RequestBody ExerciseCreationDto exercise) {
		log.info("New exercise: " + exercise);
		Exercise createdExercise = trainingService.createExercise(exercise);
		log.info("Created exercise: " + createdExercise);
		return createdExercise;
	}
}
