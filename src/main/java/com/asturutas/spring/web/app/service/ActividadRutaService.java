package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaRequestDto;
import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaResponseDto;

public interface ActividadRutaService {

	List<ActividadRutaResponseDto> findAll();

	ActividadRutaResponseDto findById(int id);

	ActividadRutaResponseDto create(ActividadRutaRequestDto actividadRutaRequestDto);

	ActividadRutaResponseDto update(int id, ActividadRutaRequestDto actividadRutaRequestDto);

	ActividadRutaResponseDto delete(int id);

}
