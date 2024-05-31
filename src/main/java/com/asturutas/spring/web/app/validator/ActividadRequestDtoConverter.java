package com.asturutas.spring.web.app.validator;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.asturutas.spring.web.app.dto.actividad.ActividadRequestDto;

@Component
public class ActividadRequestDtoConverter implements Converter<String, ActividadRequestDto> {

    @Override
    public ActividadRequestDto convert(String source) {
        ActividadRequestDto actividad = new ActividadRequestDto();
        actividad.setNombre(source);
        return actividad;
    }
}
