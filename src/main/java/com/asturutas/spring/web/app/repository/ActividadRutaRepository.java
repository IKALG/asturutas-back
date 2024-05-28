package com.asturutas.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.ActividadRutaEntity;

@Repository
public interface ActividadRutaRepository extends JpaRepository<ActividadRutaEntity, Integer> {

}
