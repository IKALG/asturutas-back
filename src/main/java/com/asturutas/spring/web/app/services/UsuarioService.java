package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Usuario;
import com.asturutas.spring.web.app.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	// @Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> obtenerTodosLosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	

}
