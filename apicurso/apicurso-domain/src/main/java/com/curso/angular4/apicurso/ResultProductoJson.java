//@formatter:off
/**
*
*       . * .
*     * RRRR  *    Copyright (c) 2016 OHIM: Office for Harmonization
*   .   RR  R   .  in the Internal Market (trade marks and designs)
*   *   RRR     *
*    .  RR RR  .   ALL RIGHTS RESERVED
*     * . _ . *
*/
//@formatter:on
package com.curso.angular4.apicurso;

import java.io.Serializable;
import java.util.List;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ResultProductoJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "ResultProductoJson", description = "ResultProductoJson domain")
public class ResultProductoJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The code. */
	@JsonProperty("code")
	private int code;

	/** The status. */
	@JsonProperty("status")
	private String status;

	/** The message. */
	@JsonProperty("message")
	private String message;

	/** The lst productos. */
	@JsonProperty("lstProductos")
	private List<ProductoJson> lstProductos;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the lst productos.
	 *
	 * @return the lst productos
	 */
	public List<ProductoJson> getLstProductos() {
		return lstProductos;
	}

	/**
	 * Sets the lst productos.
	 *
	 * @param lstProductos the new lst productos
	 */
	public void setLstProductos(List<ProductoJson> lstProductos) {
		this.lstProductos = lstProductos;
	}

	
	
}
