package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.actividad.ActividadRequestDto;
import com.asturutas.spring.web.app.dto.actividad.ActividadResponseDto;
import com.asturutas.spring.web.app.entity.ActividadEntity;

@Mapper(componentModel = "spring")
public interface ActividadMapper {

	ActividadResponseDto entityToResponseDto(ActividadEntity actividadEntity);

	ActividadEntity responseDtoToEntity(String actividad, ActividadResponseDto actividadResponseDto);

	ActividadEntity requestDtoToEntity(String actividad, ActividadRequestDto actividadRequestDto);

	ActividadEntity requestDtoToEntity(ActividadRequestDto actividadRequestDto);

	ActividadResponseDto entityToActividadResponseDto(ActividadEntity actividadEntity);

}
