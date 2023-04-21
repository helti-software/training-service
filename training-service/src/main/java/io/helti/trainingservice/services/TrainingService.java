package io.helti.trainingservice.services;

import io.helti.trainingservice.dtos.exercises.ExerciseCreationDto;
import io.helti.trainingservice.dtos.templates.TemplateCreationDto;
import io.helti.trainingservice.dtos.templates.TemplateSetsDto;
import io.helti.trainingservice.entities.exercises.Exercise;
import io.helti.trainingservice.entities.templates.Template;
import io.helti.trainingservice.entities.templates.TemplateSet;
import io.helti.trainingservice.entities.workouts.Workout;
import io.helti.trainingservice.entities.workouts.WorkoutSet;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {
	private static Long exerciseId = 1L;
	private static Long trainingId = 1L;
	private static Long workoutId = 1L;
	private static Long workoutSetId = 1L;
	private static Long templateSetId = 1L;
	private static final List<Workout> workoutsList = new ArrayList<>();
	private static final List<Exercise> exerciseList = new ArrayList<>();
	private static final List<Template> templatesList = new ArrayList<>();
	private static final List<TemplateSet> templateSetsList = new ArrayList<>();

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public Exercise getExercise(Long id) {
		return exerciseList.stream().filter(exercise -> exercise.getId().equals(id)).findFirst().orElse(null);
	}

	public Exercise createExercise(ExerciseCreationDto exercise) {
		Exercise newExercise = new Exercise();
		newExercise.setId(exerciseId++);
		newExercise.setName(exercise.name());
		newExercise.setDescription(exercise.description());
		newExercise.setEquipment(exercise.equipment());
		newExercise.setMuscleGroups(exercise.muscleGroups());
		exerciseList.add(newExercise);
		return newExercise;
	}

	public List<Template> getTemplatesList() {
		return templatesList;
	}

	public Template getTemplate(Long id) {
		return templatesList.stream().filter(training -> training.getId().equals(id)).findFirst().orElse(null);
	}

	public Template createTemplate(TemplateCreationDto creation) {
		Template template = new Template();
		template.setId(trainingId++);
		template.setName(creation.name());
		template.setSetsPerExercise(new ArrayList<>());
		for (TemplateSetsDto set : creation.exercisesSets()) {
			TemplateSet templateSet = new TemplateSet();
			templateSet.setId(templateSetId++);
			templateSet.setExerciseId(set.exerciseId());
			templateSet.setSets(set.sets());
			templateSetsList.add(templateSet);
			template.getSetsPerExercise().add(templateSet);
		}
		templatesList.add(template);
		return template;
	}

	public Workout createWorkout(Long templateId) {
		Template template = templatesList.stream().filter(training -> training.getId().equals(templateId)).findFirst().orElse(null);
		Workout workout = new Workout();
		workout.setId(workoutId++);
		workout.setName("Workout " + LocalDateTime.now());
		List<WorkoutSet> sets = new ArrayList<>();
		workout.setSets(new ArrayList<>());
		for (TemplateSet exerciseSet : template.getSetsPerExercise()) {
			for (int i = 1; i <= exerciseSet.getSets(); i++) {
				WorkoutSet workoutSet = new WorkoutSet();
				workoutSet.setId(workoutSetId++);
				workoutSet.setExerciseId(exerciseSet.getExerciseId());
				workoutSet.setSetNumber((byte) i);
				workoutSet.setReps((byte) -1); // Load from previous workout if any
				workoutSet.setWeight(-1.0f); // Load from previous workout if any
				workoutSet.setCompleted(false);
				sets.add(workoutSet);
			}
		}
		workoutsList.add(workout);
		return workout;
	}

	public Workout startWorkout(Long workoutId) {
		workoutsList.stream().filter(w -> w.getId().equals(workoutId)).findFirst().orElse(null).setStartTime(LocalDateTime.now());
		return workoutsList.stream().filter(w -> w.getId().equals(workoutId)).findFirst().orElse(null);
	}

	public Workout endWorkout(Long workoutId) {
		workoutsList.stream().filter(w -> w.getId().equals(workoutId)).findFirst().orElse(null).setEndTime(LocalDateTime.now());
		return workoutsList.stream().filter(w -> w.getId().equals(workoutId)).findFirst().orElse(null);

	}

	public WorkoutSet completeWorkoutSetById(Long workoutSetId) {
		workoutsList.stream().flatMap(workout -> workout.getSets().stream()).filter(workoutSet -> workoutSet.getId().equals(workoutSetId)).findFirst().orElse(null).setCompleted(true);
		return workoutsList.stream().flatMap(workout -> workout.getSets().stream()).filter(workoutSet -> workoutSet.getId().equals(workoutSetId)).findFirst().orElse(null);
	}

	public WorkoutSet updateWorkoutSet(WorkoutSet workoutSet) {
		return workoutSet;
	}

	public Workout getWorkoutById(Long id) {
		return workoutsList.stream().filter(workout -> workout.getId().equals(id)).findFirst().orElse(null);
	}

	public List<Workout> getWorkoutsList() {
		return workoutsList;
	}
}
