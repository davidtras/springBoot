package com.curso.angular4.apicurso.service;

import com.curso.angular4.apicurso.ProductoJson;
import com.curso.angular4.apicurso.ResultProductoJson;

public interface ProductoService {
	
	ResultProductoJson obtenerProductos();
	
	ResultProductoJson obtenerProductoPorId(String id);
	
	ResultProductoJson borrarProducto(String id);

	ResultProductoJson actualizarProducto(ProductoJson productoJson);

	ResultProductoJson guardarProducto(ProductoJson productoJson);
}
