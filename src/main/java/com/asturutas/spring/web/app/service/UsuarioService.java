package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.usuario.UsuarioRequestDto;
import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;

public interface UsuarioService {

	List<UsuarioResponseDto> findAll();

	UsuarioResponseDto findById(String usuario);

	UsuarioResponseDto create(UsuarioRequestDto usuarioRequestDto);

	UsuarioResponseDto update(String usuario, UsuarioRequestDto usuarioRequestDto);

	UsuarioResponseDto delete(String usuario);
	
	UsuarioResponseDto existsByUsername(String usuario);
	
	UsuarioResponseDto existsByEmail(String email);

}
