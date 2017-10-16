package com.curso.angular4.apicurso.dao;

import java.io.Serializable;

import com.curso.angular4.apicurso.dao.exception.DAOException;

public interface GenericDao<Entity, PK extends Serializable> {
	
	Entity findById(Class<Entity> clase,Integer id) throws DAOException;
	
	void delete(Entity persistentInstance) throws DAOException;
	
	Entity update(Entity persistentInstance) throws DAOException;

	Entity insert(Entity persistentInstance) throws DAOException;

}
