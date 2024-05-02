package com.asturutas.spring.web.app.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
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

	public Usuario() {
	}

	public Usuario(String nombre, String usuario, String email, String contrasena, Date fechaCreacion) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContraseña(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", email=" + email
				+ ", contraseña=" + contrasena + ", fechaCreacion=" + fechaCreacion + "]";
	}
}
