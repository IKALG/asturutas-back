package com.asturutas.spring.web.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asturutas.spring.web.app.models.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, String> {

}
