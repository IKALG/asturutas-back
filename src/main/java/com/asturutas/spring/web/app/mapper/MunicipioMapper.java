package com.asturutas.spring.web.app.mapper;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.municipio.MunicipioRequestDto;
import com.asturutas.spring.web.app.dto.municipio.MunicipioResponseDto;
import com.asturutas.spring.web.app.entity.MunicipioEntity;

@Mapper(componentModel = "spring")
public interface MunicipioMapper {

	MunicipioResponseDto entityToResponseDto(MunicipioEntity municipioEntity);

	MunicipioEntity responseDtoToEntity(String municipio, MunicipioResponseDto municipioResponseDto);

	MunicipioEntity requestDtoToEntity(String municipio, MunicipioRequestDto municipioRequestDto);

	MunicipioEntity requestDtoToEntity(MunicipioRequestDto municipioRequestDto);

	MunicipioResponseDto entityToMunicipioResponseDto(MunicipioEntity municipioEntity);

}
