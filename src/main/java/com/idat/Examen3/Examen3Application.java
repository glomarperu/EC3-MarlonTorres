package com.idat.Examen3;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
@EnableAutoConfiguration
public class Examen3Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen3Application.class, args);
	}

}
