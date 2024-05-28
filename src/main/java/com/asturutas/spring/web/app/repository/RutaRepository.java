package com.asturutas.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.RutaEntity;

@Repository
public interface RutaRepository extends JpaRepository<RutaEntity, Integer> {
}
