package io.helti.trainingservice.controllers;

import io.helti.trainingservice.dtos.templates.TemplateCreationDto;
import io.helti.trainingservice.entities.workouts.Workout;
import io.helti.trainingservice.services.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class WorkoutController {
	private final TrainingService trainingService;

	// Workouts
	@GetMapping("/workouts/{id}")
	public Workout getWorkout(@PathVariable Long id) {
		log.info("Getting workout with id: " + id);
		Workout workout = trainingService.getWorkoutById(id);
		log.info("Workout: " + workout);
		return workout;
	}

	@GetMapping("/workouts")
	public List<Workout> getWorkouts() {
		log.info("Getting all workouts");
		return trainingService.getWorkoutsList();
	}

	@PostMapping("/workout")
	public Workout createWorkout(TemplateCreationDto template) {
		return trainingService.createWorkout(template);
	}

	@PutMapping("/workouts/{id}/start")
	public Workout startWorkout(@PathVariable Long id) {
		log.info("Starting workout with id: " + id);
		Workout workout = trainingService.startWorkout(id);
		log.info("Workout started: " + (workout.getStartTime() != null));
		return workout;
	}

	@PutMapping("/workouts/{id}/end")
	public Workout finishWorkout(@PathVariable Long id) {
		log.info("Finishing workout with id: " + id);
		Workout workout = trainingService.endWorkout(id);
		log.info("Workout finished: " + (workout.getEndTime() != null));
		return workout;
	}
}
