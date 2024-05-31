package com.asturutas.spring.web.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asturutas.spring.web.app.validator.ActividadRequestDtoConverter;
import com.asturutas.spring.web.app.validator.MunicipioRequestDtoConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ActividadRequestDtoConverter actividadRequestDtoConverter;
    private final MunicipioRequestDtoConverter municipioRequestDtoConverter;

    public WebConfig(ActividadRequestDtoConverter actividadRequestDtoConverter, MunicipioRequestDtoConverter municipioRequestDtoConverter) {
        this.actividadRequestDtoConverter = actividadRequestDtoConverter;
        this.municipioRequestDtoConverter = municipioRequestDtoConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(actividadRequestDtoConverter);
        registry.addConverter(municipioRequestDtoConverter);
    }
}
