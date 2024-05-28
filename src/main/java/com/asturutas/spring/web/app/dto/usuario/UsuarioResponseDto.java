package com.asturutas.spring.web.app.dto.usuario;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponseDto {

	private String nombre;

	private String usuario;

	private String email;

	private String contrasena;

	private Date fechaCreacion;

}
