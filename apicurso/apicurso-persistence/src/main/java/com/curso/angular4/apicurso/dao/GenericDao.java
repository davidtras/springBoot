package com.curso.angular4.apicurso.dao;

import java.io.Serializable;

public interface GenericDao<Entity, PK extends Serializable> {
	
	Entity findById(Class<Entity> clase,Integer id);
	
	void delete(Entity persistentInstance);

}
