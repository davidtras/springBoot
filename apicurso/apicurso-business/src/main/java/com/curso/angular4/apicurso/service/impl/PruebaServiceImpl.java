package com.curso.angular4.apicurso.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.angular4.apicurso.PruebaJson;
import com.curso.angular4.apicurso.dao.UserDao;
import com.curso.angular4.apicurso.entities.User;
import com.curso.angular4.apicurso.service.PruebaService;

@Service
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public PruebaJson devolverMensaje(String nombre) {
		
		User user =userDao.findById(User.class,1);
		PruebaJson pruebaJson = new PruebaJson();
		String mensaje = "Hola " + user.getName();
		pruebaJson.setMensaje(mensaje);
		return pruebaJson;
	}
	
	@Transactional
	public PruebaJson borrarUsuario(Integer id) {
		
		User user =userDao.findById(User.class,1);
		userDao.delete(user);
		PruebaJson pruebaJson = new PruebaJson();
		pruebaJson.setMensaje("Usuario borrado");
		return pruebaJson;
	}

}
