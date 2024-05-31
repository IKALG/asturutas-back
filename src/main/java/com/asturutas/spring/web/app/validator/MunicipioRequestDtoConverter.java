package com.asturutas.spring.web.app.validator;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.asturutas.spring.web.app.dto.municipio.MunicipioRequestDto;

@Component
public class MunicipioRequestDtoConverter implements Converter<String, MunicipioRequestDto> {

    @Override
    public MunicipioRequestDto convert(String source) {
        MunicipioRequestDto municipio = new MunicipioRequestDto();
        municipio.setNombre(source);
        return municipio;
    }
}