package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaRequestDto;
import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaResponseDto;
import com.asturutas.spring.web.app.entity.MunicipioRutaEntity;

@Mapper(componentModel = "spring")
public interface MunicipioRutaMapper {

	MunicipioRutaEntity responseDtoToEntity(int id, MunicipioRutaResponseDto municipioRutaResponseDto);

	MunicipioRutaEntity requestDtoToEntity(int id, MunicipioRutaRequestDto municipioRutaRequestDto);

	MunicipioRutaEntity requestDtoToEntity(MunicipioRutaRequestDto municipioRutaRequestDto);

	MunicipioRutaResponseDto entityToMunicipioRutaResponseDto(MunicipioRutaEntity municipioRutaEntity);

}
