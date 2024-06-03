package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asturutas.spring.web.app.dto.usuario.UsuarioRequestDto;
import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;
import com.asturutas.spring.web.app.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model model) {
        List<UsuarioResponseDto> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "lista-usuarios";
    }

    @GetMapping("/usuarios/registrar")
    public String añadirUsuario(Model model) {
        model.addAttribute("usuarioRequestDto", new UsuarioRequestDto()); 
        return "registrate";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute UsuarioRequestDto usuarioRequestDto, Model model) {
        if (usuarioService.existsByUsername(usuarioRequestDto.getUsuario()) != null) {
            model.addAttribute("errorUsername", "El nombre de usuario ya está en uso");
            return "registrate";
        }

        if (usuarioService.existsByEmail(usuarioRequestDto.getEmail()) != null) {
            model.addAttribute("errorEmail", "El correo electrónico ya está en uso");
            return "registrate";
        }

        usuarioService.create(usuarioRequestDto);
        model.addAttribute("registroCorrecto", usuarioRequestDto.getNombre() + ", tu usuario ha sido registrado con éxito");
        return "registrate";
    }
    
    @GetMapping("usuarios/iniciar")
    public String iniciarUsuario(Model model) {
    	return "login";
    }
    
}
