package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.consulta.ConsultaRequestDto;
import com.asturutas.spring.web.app.dto.consulta.ConsultaResponseDto;
import com.asturutas.spring.web.app.entity.ConsultaEntity;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

	ConsultaResponseDto entityToResponseDto(ConsultaEntity consultaEntity);

	ConsultaEntity responseDtoToEntity(String consulta, ConsultaResponseDto consultaResponseDto);

	ConsultaEntity requestDtoToEntity(String consulta, ConsultaRequestDto consultaRequestDto);

	ConsultaEntity requestDtoToEntity(ConsultaRequestDto consultaRequestDto);

	ConsultaResponseDto entityToConsultaResponseDto(ConsultaEntity consultaEntity);

}
