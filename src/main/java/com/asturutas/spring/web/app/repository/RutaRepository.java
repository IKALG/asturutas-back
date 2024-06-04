package com.asturutas.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.RutaEntity;

@Repository
public interface RutaRepository extends JpaRepository<RutaEntity, Integer> {
	
	@Query("SELECT r FROM RutaEntity r JOIN r.actividades a WHERE upper(a.nombre) = upper(?1)")
	List<RutaEntity> findRutasByActividad(String actividad);
	
	@Query("SELECT r FROM RutaEntity r JOIN r.municipios m WHERE upper(m.nombre) = upper(?1)")
	List<RutaEntity> findRutasByMunicipio(String municipio);

}
