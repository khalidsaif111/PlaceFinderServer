package com.placefinderserver.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.placefinderserver.model.Activity;
import com.placefinderserver.model.Exercise;
import com.placefinderserver.util.HibernateUtilities;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}

	public Exercise addExercise(Exercise exercise) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtilities.getInstance().getSessionFactory()
					.openSession();
			transaction = session.beginTransaction();
			session.save(exercise);
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return exercise;
	}
	
}
