package com.curso.angular4.apicurso.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.angular4.apicurso.ProductoJson;
import com.curso.angular4.apicurso.ResultProductoJson;
import com.curso.angular4.apicurso.dao.ProductoDao;
import com.curso.angular4.apicurso.dao.exception.DAOException;
import com.curso.angular4.apicurso.entities.Producto;
import com.curso.angular4.apicurso.service.ProductoService;
import com.curso.angular4.apicurso.service.utils.Constants;
import com.curso.angular4.apicurso.service.utils.Utils;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;

	@Override
	public ResultProductoJson obtenerProductos() {
		
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
		List<Producto> lstProductos = productoDao.searchAll();
		for(Producto producto : lstProductos){
			lstProdJson.add(Utils.mapProductoJson(producto));
		}
		result.setLstProductos(lstProdJson);
		result.setCode(Constants.CODE_200);
		result.setStatus(Constants.SUCCESS);
		result.setMessage(String.format("Se han recuperado %s productos",lstProdJson.size()));
		return result;
	}

	public ResultProductoJson obtenerProductoPorId(String id) {
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
		try {
			Producto producto = productoDao.findById(Producto.class, Integer.parseInt(id));
			if(null != producto){
				lstProdJson.add(Utils.mapProductoJson(producto));
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha recuperado el producto con el id %s",id));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
			}
		} catch (NumberFormatException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El id %s no tiene un formato válido",id));
		} catch (DAOException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
		}
		result.setLstProductos(lstProdJson);
		return result;
	}

	@Transactional
	public ResultProductoJson borrarProducto(String id) {
		ResultProductoJson result = new ResultProductoJson();
		try {
			Producto producto = productoDao.findById(Producto.class, Integer.parseInt(id));
			if(null != producto){
				productoDao.delete(producto);
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha eliminado el producto con el id %s",id));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
			}
		} catch (NumberFormatException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El id %s no tiene un formato válido",id));
		} catch (DAOException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El producto correspondiente al id %s no está disponible",id));
		}
		return result;
	}

	@Transactional
	public ResultProductoJson actualizarProducto(ProductoJson productoJson) {
		ResultProductoJson result = new ResultProductoJson();
		try {
			Producto producto = productoDao.findById(Producto.class, productoJson.getId());
			if(null != producto){
				producto.setDescription(productoJson.getDescription());
				producto.setNombre(productoJson.getNombre());
				producto.setPrecio(productoJson.getPrecio());
				producto.setImagen(productoJson.getImagen());
				productoDao.update(producto);
				result.setCode(Constants.CODE_200);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(String.format("Se ha actualizado el producto con el id %s",productoJson.getId()));
			}else{
				result.setCode(Constants.CODE_404);
				result.setStatus(Constants.ERROR);
				result.setMessage(String.format("El producto con id %s no se ha modificado correctamente",productoJson.getId()));
			}
		} catch (DAOException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El producto correspondiente al id %s no está disponible",productoJson.getId()));
		}
		return result;
	}

	@Transactional
	public ResultProductoJson guardarProducto(ProductoJson productoJson) {
		ResultProductoJson result = new ResultProductoJson();
		List<ProductoJson> lstProdJson = new ArrayList<>();
		try {
			Producto producto = new Producto();
			producto.setDescription(productoJson.getDescription());
			producto.setNombre(productoJson.getNombre());
			producto.setPrecio(productoJson.getPrecio());
			producto.setImagen(productoJson.getImagen());
			productoDao.insert(producto);
			productoJson.setId(producto.getId());
			lstProdJson.add(productoJson);
			result.setLstProductos(lstProdJson);
			result.setCode(Constants.CODE_200);
			result.setStatus(Constants.SUCCESS);
			result.setMessage(String.format("Se ha insertado correctamente el producto con el id %s",productoJson.getId()));
		} catch (DAOException e) {
			result.setCode(Constants.CODE_404);
			result.setStatus(Constants.ERROR);
			result.setMessage(String.format("El producto no se ha creado correctamente"));
		}
		return result;
	}
	
	

}
