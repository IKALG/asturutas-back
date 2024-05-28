package com.asturutas.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.entity.ActividadEntity;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadEntity, String> {

}
