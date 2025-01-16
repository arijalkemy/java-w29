package com.ejemplodeinyecciondependencias.book.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class JavaDevConfig {

    @PostConstruct
    public void initialize(){
        System.out.println("------ Iniciando el ambiente de Dev --------");
    }
}
