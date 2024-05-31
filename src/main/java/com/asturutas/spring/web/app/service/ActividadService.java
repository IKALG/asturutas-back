package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.actividad.ActividadRequestDto;
import com.asturutas.spring.web.app.dto.actividad.ActividadResponseDto;

public interface ActividadService {

	List<ActividadResponseDto> findAll();

	ActividadResponseDto findByNombre(String actividad);

	ActividadResponseDto create(ActividadRequestDto actividadRequestDto);

	ActividadResponseDto update(String actividad, ActividadRequestDto actividadRequestDto);

	ActividadResponseDto delete(String actividad);
}
