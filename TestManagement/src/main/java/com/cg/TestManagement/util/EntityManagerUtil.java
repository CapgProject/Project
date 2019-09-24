package com.cg.TestManagement.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;
	
	public EntityManagerFactory getEntiManagerFactory() {
		return entityManagerFactory;
	}
	public void setEntiManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void initializeEntity() {
		entityManagerFactory = Persistence.createEntityManagerFactory("OnlineTestManagement");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
}
