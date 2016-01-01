package com.placefinderserver.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Class to create session factory at load time.
 * 
 * @author khalidsaif
 *
 */
public class HibernateUtilities {

	private static HibernateUtilities hibernateUtilities;

	/**
	 * Create private constructor
	 */
	private HibernateUtilities() {

	}

	/**
	 * Static method to get single instance of this class.
	 */
	public static HibernateUtilities getInstance() {
		if (hibernateUtilities == null) {
			hibernateUtilities = new HibernateUtilities();
		}
		return hibernateUtilities;
	}

	private SessionFactory sessionFactory = null;
	private ServiceRegistry serviceRegistry = null;

	/**
	 * method to get session factory object
	 * 
	 * @return
	 */
	public SessionFactory getSessionFactory() {

		if (this.sessionFactory == null) {
			/* configures settings from hibernate.cfg.xml */
			final Configuration configuration = new Configuration().configure();
			final StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			this.serviceRegistry = serviceRegistryBuilder.build();
			this.sessionFactory = configuration
					.buildSessionFactory(this.serviceRegistry);
		}
		return this.sessionFactory;
	}

	/**
	 * method to get service registry object
	 * 
	 * @return
	 */
	public ServiceRegistry getServiceRegistry() {
		return this.serviceRegistry;
	}

	/**
	 * Method to destroy service registry at program termination.
	 */
	public static void destroyServiceRegistry() {
		final ServiceRegistry serviceRegistry = HibernateUtilities
				.getInstance().getServiceRegistry();
		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
}
