package com.curso.angular4.apicurso.dao;

import java.util.List;

import com.curso.angular4.apicurso.dao.exception.DAOException;
import com.curso.angular4.apicurso.entities.Producto;

public interface ProductoDao extends GenericDao<Producto, Long> {

	Producto searchByPk(int i) throws DAOException;
	
	List<Producto> searchAll();

}
