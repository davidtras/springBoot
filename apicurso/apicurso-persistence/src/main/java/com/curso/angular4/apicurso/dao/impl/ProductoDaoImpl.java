package com.curso.angular4.apicurso.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.curso.angular4.apicurso.dao.ProductoDao;
import com.curso.angular4.apicurso.dao.exception.DAOException;
import com.curso.angular4.apicurso.entities.Producto;

@Repository
public class ProductoDaoImpl extends GenericDaoImpl<Producto, Long> implements ProductoDao {
	
	public Producto searchByPk(int id) throws DAOException {
		return this.findById(Producto.class,id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Producto> searchAll() {
		return (List<Producto>) entityManager.createNamedQuery("Producto.findAll").getResultList();
	}

}
