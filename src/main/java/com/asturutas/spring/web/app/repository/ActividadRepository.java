package com.asturutas.spring.web.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.dto.actividad.ActividadResponseDto;
import com.asturutas.spring.web.app.entity.ActividadEntity;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadEntity, String> {
	
//	Optional<ActividadResponseDto> findByNombre(String actividad);
	Optional<ActividadEntity> findByNombre(String actividad);

}
