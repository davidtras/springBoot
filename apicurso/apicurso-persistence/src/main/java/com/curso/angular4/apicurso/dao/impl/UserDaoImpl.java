package com.curso.angular4.apicurso.dao.impl;

import org.springframework.stereotype.Repository;

import com.curso.angular4.apicurso.dao.UserDao;
import com.curso.angular4.apicurso.entities.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
	
	public User searchByPk(int id) {
		return this.findById(User.class,id);
		
	}

}
