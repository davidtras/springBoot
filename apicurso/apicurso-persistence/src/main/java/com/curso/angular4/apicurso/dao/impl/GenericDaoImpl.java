package com.curso.angular4.apicurso.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import com.curso.angular4.apicurso.dao.GenericDao;
import com.curso.angular4.apicurso.dao.exception.DAOException;

public class GenericDaoImpl<Entity, K extends Serializable> implements GenericDao<Entity, K> {

	
	 @PersistenceContext
	 protected EntityManager entityManager;

	public Entity insert(Entity transientInstance) throws DAOException {
		try {
			entityManager.persist(transientInstance);
			return transientInstance;
		} catch (RuntimeException re) {
			throw new DAOException("Error en al guardar",re);
		}
	}

	public void delete(Entity persistentInstance) throws DAOException {
		try {
			entityManager.remove(persistentInstance);
		} catch (RuntimeException re) {
			throw new DAOException("Error en al borrar",re);
		}
	}

	public Entity update(Entity detachedInstance) throws DAOException {

		try {
			Entity result = (Entity) entityManager.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			throw new DAOException("Error en al actualizar",re);
		}
	}

	public Entity findById(Class<Entity> clase,Integer id) throws DAOException {
		try {
			return (Entity) entityManager.find(clase, id);
		} catch (Exception e) {
			throw new DAOException("Error en al buscar por id",e);
		}
	}
}
