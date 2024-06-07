package com.asturutas.spring.web.app.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;

import com.asturutas.spring.web.app.dto.usuario.UsuarioRequestDto;
import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;
import com.asturutas.spring.web.app.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioEntity responseDtoToEntity(String usuario, UsuarioResponseDto usuarioResponseDto);

	UsuarioEntity requestDtoToEntity(String usuario, UsuarioRequestDto usuarioRequestDto);

	UsuarioEntity requestDtoToEntity(UsuarioRequestDto usuarioRequestDto);

	UsuarioResponseDto entityToUsuarioResponseDto(UsuarioEntity usuarioEntity);

	UsuarioRequestDto entityToUsuarioRequestDto(UsuarioEntity usuarioEntity);

	UsuarioResponseDto entityToUsuarioResponseDto(Optional<UsuarioEntity> usuarioEntity);

	UsuarioEntity usuarioRequestDtoToEntity(UsuarioRequestDto usuarioRequestDto);

	UsuarioEntity usuarioRequestDtoToEntity(String usuario, UsuarioRequestDto usuarioRequestDto);


}
