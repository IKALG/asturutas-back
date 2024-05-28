package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.ruta.RutaRequestDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;
import com.asturutas.spring.web.app.entity.RutaEntity;

@Mapper(componentModel = "spring")
public interface RutaMapper {

	RutaEntity responseDtoToEntity(int id, RutaResponseDto rutaResponseDto);

	RutaEntity requestDtoToEntity(int id, RutaRequestDto rutaRequestDto);

	RutaEntity requestDtoToEntity(RutaRequestDto rutaRequestDto);

	RutaResponseDto entityToRutaResponseDto(RutaEntity rutaEntity);
}
