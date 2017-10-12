package com.curso.angular4.apicurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ApicursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicursoApplication.class, args);
	}
}
