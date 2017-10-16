package com.curso.angular4.apicurso;

import java.io.Serializable;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class FileUploadJson.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiObject(name = "FileUploadJson", description = "FileUploadJson domain")
public class FileUploadJson implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The code. */
	@JsonProperty("code")
	private Integer code;

	/** The status. */
	@JsonProperty("status")
	private String status;

	/** The message. */
	@JsonProperty("message")
	private String message;

	
	/** The filename. */
	@JsonProperty("filename")
	private String filename;


	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}


	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(Integer code) {
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
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}


	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	

	
	
}
