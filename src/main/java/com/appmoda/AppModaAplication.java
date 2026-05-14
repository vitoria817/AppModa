package com.appmoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class AppModaAplication {
    public static void main(String[] args) {
        SpringApplication.run(AppModaAplication.class, args);
    }
//não mexa aqui, ele so executa o sistema, não escreva nada
    //CRUD banco de dados
    //repositorio ta pronto
    //fazer diagrama
    //front
    //classe abstrata
}

