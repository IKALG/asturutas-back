package com.asturutas.spring.web.app.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@ToString
public class UsuarioEntity {

	@Column(name = "nombre")
	private String nombre;

	@Id
	@Column(name = "usuario")
	private String usuario;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "fechaCreacion")
	private Date fechaCreacion;

	public UsuarioEntity() {
	}

	public UsuarioEntity(String nombre, String usuario, String email, String contrasena, Date fechaCreacion) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
	}
}
