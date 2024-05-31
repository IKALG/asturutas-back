package com.asturutas.spring.web.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.MunicipioEntity;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity, String> {
	
	Optional<MunicipioEntity> findByNombre(String municipio);

}
