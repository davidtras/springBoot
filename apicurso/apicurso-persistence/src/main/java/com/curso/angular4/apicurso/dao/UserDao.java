package com.curso.angular4.apicurso.dao;

import com.curso.angular4.apicurso.entities.User;

public interface UserDao extends GenericDao<User, Long> {

	User searchByPk(int i);

}
