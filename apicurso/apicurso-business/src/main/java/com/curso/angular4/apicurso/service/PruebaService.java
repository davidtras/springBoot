package com.curso.angular4.apicurso.service;

import com.curso.angular4.apicurso.PruebaJson;

public interface PruebaService {
	
	PruebaJson devolverMensaje(String nombre);
	
	 PruebaJson borrarUsuario(Integer id);

}
