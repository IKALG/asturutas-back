package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.ruta.RutaRequestDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;

public interface RutaService {

	List<RutaResponseDto> findAll();

	RutaResponseDto findById(int id);

	RutaResponseDto create(RutaRequestDto rutaRequestDto);

	RutaResponseDto update(int id, RutaRequestDto rutaRequestDto);

	RutaResponseDto delete(int id);
}
