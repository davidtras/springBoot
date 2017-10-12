package com.curso.angular4.apicurso.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.curso.angular4.apicurso.dao.GenericDao;

public class GenericDaoImpl<Entity, K extends Serializable> implements GenericDao<Entity, K> {


//	@Autowired
//	private SessionFactory sessionFactory;
	
	 @PersistenceContext
	 private EntityManager entityManager;

	public void persist(Entity transientInstance) {
		//log.debug("persisting Entity instance");
		try {
			entityManager.persist(transientInstance);
			//log.debug("persist successful");
		} catch (RuntimeException re) {
			//log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Entity persistentInstance) {
		//log.debug("deleting Entity instance");
		try {
			entityManager.remove(persistentInstance);
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}

	public Entity merge(Entity detachedInstance) {
		//log.debug("merging Entity instance");
		try {
			Entity result = (Entity) entityManager.merge(detachedInstance);
			//log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			//log.error("merge failed", re);
			throw re;
		}
	}

	public Entity findById(Class<Entity> clase,Integer id) {
		//log.debug("getting Entity instance with id: " + id);
		try {

			Entity instance = (Entity) entityManager.find(clase, id);
			if (instance == null) {
				//log.debug("get successful, no instance found");
			} else {
				//log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			throw re;
		}
	}

}
