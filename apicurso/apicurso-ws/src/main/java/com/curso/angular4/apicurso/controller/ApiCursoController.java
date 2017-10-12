package com.curso.angular4.apicurso.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular4.apicurso.PruebaJson;
import com.curso.angular4.apicurso.service.PruebaService;

@Api(name = "Api curso", description = "Metodos para el curso de angular", group = "Main")
@RestController
@RequestMapping(path = "/cursoangular", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiCursoController {

	@Autowired
	private PruebaService pruebaService;
	
	@ApiMethod(description = "Service to get correspondance data")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/prueba")
	public PruebaJson getPrueba(@RequestParam(value = "nombre", required = true) String nombre) {
		
		return pruebaService.devolverMensaje(nombre);
	}

	
	@ApiMethod(description = "Service to get correspondance data")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/borrar")
	public PruebaJson borrar(@RequestParam(value = "id", required = true) String id) {
		
		return pruebaService.borrarUsuario(Integer.parseInt(id));
	}
}
