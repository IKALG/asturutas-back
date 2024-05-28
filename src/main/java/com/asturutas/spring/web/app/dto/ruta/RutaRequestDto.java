package com.asturutas.spring.web.app.dto.ruta;

import java.util.List;

import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaResponseDto;
import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RutaRequestDto {

	private String nombre;

	private String descripcion;

	private float distancia;

	private String dificultad;

	private float duracion;

	private String fotos;

	private List<ActividadRutaResponseDto> actividades;

	private String usuario;

	private List<MunicipioRutaResponseDto> municipios;

	private boolean movilidadReducida;

	private boolean aptoNinos;

	private boolean aptoPerros;

}
