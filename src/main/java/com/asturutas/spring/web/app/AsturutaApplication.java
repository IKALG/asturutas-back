package com.asturutas.spring.web.app;

import java.sql.Driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsturutaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsturutaApplication.class, args);
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("El controlador JDBC de PostgreSQL está cargado.");
		} catch (ClassNotFoundException e) {
			System.out.println("El controlador JDBC de PostgreSQL no está cargado.");
			return;
		}

	}
}
