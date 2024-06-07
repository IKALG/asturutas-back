package com.asturutas.spring.web.app.dto.consulta;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsultaRequestDto {
    
    private String correo;
    private String mensaje;
    private boolean leido; // Campo para indicar si la consulta ha sido leída

    // Constructor, getters y setters
}
