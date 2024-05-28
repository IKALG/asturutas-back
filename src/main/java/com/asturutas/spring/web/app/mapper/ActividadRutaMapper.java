package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaRequestDto;
import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaResponseDto;
import com.asturutas.spring.web.app.entity.ActividadRutaEntity;

@Mapper(componentModel = "spring")
public interface ActividadRutaMapper {

	ActividadRutaEntity responseDtoToEntity(int id, ActividadRutaResponseDto actividadRutaResponseDto);

	ActividadRutaEntity requestDtoToEntity(int id, ActividadRutaRequestDto actividadRutaRequestDto);

	ActividadRutaEntity requestDtoToEntity(ActividadRutaRequestDto actividadRutaRequestDto);

	ActividadRutaResponseDto entityToActividadRutaResponseDto(ActividadRutaEntity actividadRutaEntity);

}
