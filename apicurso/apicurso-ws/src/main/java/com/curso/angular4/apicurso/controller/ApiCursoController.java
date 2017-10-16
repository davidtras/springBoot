package com.curso.angular4.apicurso.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.curso.angular4.apicurso.FileUploadJson;
import com.curso.angular4.apicurso.ProductoJson;
import com.curso.angular4.apicurso.ResultProductoJson;
import com.curso.angular4.apicurso.service.ProductoService;
import com.curso.angular4.apicurso.service.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Api(name = "Api curso", description = "Metodos para el curso de angular", group = "Main")
@RestController
@RequestMapping(path = "/cursoangular", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiCursoController {

	@Value("${url.uploader.folder}")
	private String UPLOADED_FOLDER;
	
	@Autowired
	private ProductoService productoService;
	
	@ApiMethod(description = "Obtener la lista con todos los productos")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/productos")
	public ResultProductoJson getProductos() {

		return productoService.obtenerProductos();
	}
	
	@ApiMethod(description = "Obtener un producto por su id")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/producto")
	public ResultProductoJson getProductByid(@RequestParam(value="id",required=true) String id) {

		return productoService.obtenerProductoPorId(id);
	}
	
	@ApiMethod(description = "Obtener un producto por su id")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/delete-producto")
	public ResultProductoJson borrarProducto(@RequestParam(value="id",required=true) String id) {

		return productoService.borrarProducto(id);
	}
	
	@ApiMethod(description = "Obtener un producto por su id")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/update-producto")
	public ResultProductoJson actualizarProducto(@RequestBody ProductoJson productoJson) {

		return productoService.actualizarProducto(productoJson);
	}
	
	@ApiMethod(description = "Obtener un producto por su id")
	@ApiResponseObject
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/save-producto")
	public ResultProductoJson guardarProducto(@RequestBody ProductoJson productoJson) {

		return productoService.guardarProducto(productoJson);
	}
	
	@PostMapping("/upload-file")
    public FileUploadJson singleFileUpload(@RequestParam(value="file",required=true) MultipartFile file) {

		FileUploadJson result = new FileUploadJson();
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            result.setCode(Constants.CODE_200);
            result.setMessage("El archivo se ha subido correctamente");
            result.setStatus(Constants.SUCCESS);
            result.setFilename(file.getOriginalFilename());
        } catch (IOException e) {
        	result.setCode(Constants.CODE_404);
            result.setMessage("El archivo no se ha subido correctamente");
            result.setStatus(Constants.ERROR);
            result.setFilename(file.getOriginalFilename());
        }

        return result;
    }

}
