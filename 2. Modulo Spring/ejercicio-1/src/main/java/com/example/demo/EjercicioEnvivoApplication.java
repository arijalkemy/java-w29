package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//CLASE QUE INICIALIZA EL PROYECTO DE SPRING PORQUE TIENE UN METODO MAIN
// ESTA ANOTACION INICIALIZA EL CONTEXTO DE SPRING
@SpringBootApplication
public class EjercicioEnvivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioEnvivoApplication.class, args);
	}

}
