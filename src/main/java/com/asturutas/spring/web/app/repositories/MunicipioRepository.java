package com.asturutas.spring.web.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asturutas.spring.web.app.models.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, String> {

}
