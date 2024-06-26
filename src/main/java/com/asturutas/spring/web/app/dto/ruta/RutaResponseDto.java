package com.asturutas.spring.web.app.dto.ruta;

import java.util.Set;

import com.asturutas.spring.web.app.dto.actividad.ActividadRequestDto;
import com.asturutas.spring.web.app.dto.municipio.MunicipioRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RutaResponseDto {

	private Integer id;
	
	private String nombre;

	private String descripcion;

	private float distancia;

	private String dificultad;

	private float duracion;
	
	private String fotouno;
	
	private String fotodos;
	
	private String fototres;
	
	private String fotocuatro;
	
	private String fotocinco;
	
	private Set<ActividadRequestDto> actividades;

	private String usuario;

	private Set<MunicipioRequestDto> municipios;
	
	private boolean movilidadReducida;

	private boolean aptoNinos;

	private boolean aptoPerros;
}
