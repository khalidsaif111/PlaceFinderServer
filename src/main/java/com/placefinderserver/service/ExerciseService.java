package com.placefinderserver.service;

import java.util.List;

import com.placefinderserver.model.Activity;
import com.placefinderserver.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();
	
	Exercise addExercise(Exercise exercise);

}