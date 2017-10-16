package com.curso.angular4.apicurso.service.utils;

import com.curso.angular4.apicurso.ProductoJson;
import com.curso.angular4.apicurso.entities.Producto;

public class Utils {
	
	/**
	 * Map producto json.
	 *
	 * @param producto the producto
	 * @return the producto json
	 */
	public static ProductoJson mapProductoJson(Producto producto){
		
		ProductoJson prodJson = new ProductoJson();
		prodJson.setId(producto.getId());
		prodJson.setDescription(producto.getDescription());
		prodJson.setNombre(producto.getNombre());
		prodJson.setPrecio(producto.getPrecio());
		prodJson.setImagen(producto.getImagen());
		
		return prodJson;
	}

}
