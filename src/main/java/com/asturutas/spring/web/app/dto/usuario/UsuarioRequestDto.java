package com.asturutas.spring.web.app.dto.usuario;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequestDto {

	private String nombre;

	private String usuario;

	private String email;

	private String contrasena;

	private Date fechaCreacion;
}
