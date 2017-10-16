package com.curso.angular4.apicurso;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ProductoJson", description = "ProductoJson domain")
public class ProductoJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private int id;

	@JsonProperty("description")
	private String description;

	@JsonProperty("imagen")
	private String imagen;

	@JsonProperty("nombre")
	private String nombre;

	@JsonProperty("precio")
	private String precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}	
	
}
