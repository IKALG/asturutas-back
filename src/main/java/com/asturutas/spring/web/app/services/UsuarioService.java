package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Usuario;
import com.asturutas.spring.web.app.repositories.UsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
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
	
	public void guardarUsuario (Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public boolean existsByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        return usuario != null;
    }

    public boolean existsByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null;
    }
	
}
