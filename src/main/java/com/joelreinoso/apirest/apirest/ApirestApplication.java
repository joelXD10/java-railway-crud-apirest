package com.joelreinoso.apirest.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


///Hace la configuracion inicial por defecto de Spring Boot
@SpringBootApplication
public class ApirestApplication {

	public static void main(String[] args) {

		//Se debe tener abierto Docker y Tableplus para que se ejecute sin problemas
		SpringApplication.run(ApirestApplication.class, args);

	}

}
