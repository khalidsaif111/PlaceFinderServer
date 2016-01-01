package com.placefinderserver.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.placefinderserver.model.Goal;
import com.placefinderserver.service.GoalService;
import com.placefinderserver.util.HibernateUtilities;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	public Goal addGoal(Goal goal) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtilities.getInstance().getSessionFactory()
					.openSession();
			transaction = session.beginTransaction();
			session.save(goal);
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
		
		return goal;
	}

}
