package com.placefinderserver.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.placefinderserver.model.Authority;
import com.placefinderserver.model.UserInfo;
import com.placefinderserver.model.UserLoginInfo;
import com.placefinderserver.service.UserService;
import com.placefinderserver.util.HibernateUtilities;
import com.placefinderserver.util.PlaceFinderUtil;

@Service
public class UserServiceImpl implements UserService {

	public UserInfo addUserInfo(UserInfo userInfo) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtilities.getInstance().getSessionFactory()
					.openSession();
			transaction = session.beginTransaction();
			session.save(userInfo);
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
		
		return userInfo;
	}

	public UserLoginInfo addUserLoginInfo(UserLoginInfo userLoginInfo) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtilities.getInstance().getSessionFactory()
					.openSession();
			transaction = session.beginTransaction();
			session.save(userLoginInfo);
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
		
		return userLoginInfo;
	}

	public void addUserAuthorities(String username, List<String> authorities) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtilities.getInstance().getSessionFactory()
					.openSession();
			transaction = session.beginTransaction();
			for(String authority : authorities) {
				session.save(PlaceFinderUtil.getAuthority(username, authority));
			}
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
