package com.asturutas.spring.web.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
	
	Optional<UsuarioEntity> findByUsuario(String username);

	Optional<UsuarioEntity> findByEmail(String email);	
	
}
