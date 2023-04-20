package io.helti.trainingservice;

import io.helti.trainingservice.entities.exercises.Exercise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TrainingServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		Exercise benchPress = new Exercise();
		benchPress.setId(1L);
		benchPress.setName("Bench Press");
		benchPress.setDescription("Lay down on a bench and push the barbell up");
		benchPress.setEquipment(Collections.singletonList("Barbell, Bench"));
		benchPress.setMuscleGroups(Collections.singletonList("Chest, Triceps"));
		System.out.println(benchPress);

		Exercise deadlift = new Exercise();
		deadlift.setId(2L);
		deadlift.setName("Deadlift");
		deadlift.setDescription("Lift the barbell from the ground");
		deadlift.setEquipment(Collections.singletonList("Barbell, Floor"));
		deadlift.setMuscleGroups(Collections.singletonList("Back, Legs, Glutes"));
		System.out.println(deadlift);

		Exercise squat = new Exercise();
		squat.setId(3L);
		squat.setName("Squat");
		squat.setDescription("Lift the barbell up");
		squat.setEquipment(Collections.singletonList("Barbell, Floor"));
		squat.setMuscleGroups(Collections.singletonList("Back, Spine"));
		System.out.println(squat);

		SpringApplication.run(TrainingServiceApplication.class, args);

	}

}
