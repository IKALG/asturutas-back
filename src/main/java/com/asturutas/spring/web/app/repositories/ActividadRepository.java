package com.asturutas.spring.web.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.models.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, String> {

}
