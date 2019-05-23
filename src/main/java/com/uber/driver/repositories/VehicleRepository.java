package com.uber.driver.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uber.driver.entities.VehicleEntity;

@Repository
public class VehicleRepository {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public void save(VehicleEntity vehicleEntity) {
		entityManager.persist(vehicleEntity);
	}
	
	@Transactional
	public VehicleEntity findById(Integer id) {
		return entityManager.find(VehicleEntity.class, id);
	}
	
}