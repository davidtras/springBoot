package com.curso.angular4.apicurso;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "PruebaJson", description = "PruebaJson domain")
public class PruebaJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@JsonProperty("mensaje")
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
