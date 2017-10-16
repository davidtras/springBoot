package com.curso.angular4.apicurso.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.angular4.apicurso.FileUploadJson;
import com.curso.angular4.apicurso.dao.ProductoDao;
import com.curso.angular4.apicurso.entities.Producto;
import com.curso.angular4.apicurso.service.PruebaService;

@Service
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public FileUploadJson devolverMensaje(String nombre) {
		
//		Producto producto =productoDao.findById(Producto.class,1);
//		PruebaJson pruebaJson = new PruebaJson();
//		String mensaje = "Hola " + producto.getDescription();
//		pruebaJson.setMensaje(mensaje);
//		return pruebaJson;
		return null;
	}
	

}
