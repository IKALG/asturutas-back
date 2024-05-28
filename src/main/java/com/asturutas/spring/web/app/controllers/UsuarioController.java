package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;
import com.asturutas.spring.web.app.entity.UsuarioEntity;
import com.asturutas.spring.web.app.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/usuarios")
	public String mostrarUsuarios(Model model) {
		List<UsuarioResponseDto> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		return "lista-usuarios";
	}
}

//	@GetMapping("/registrate")
//	public String añadirUsuario(Model model) {
//        model.addAttribute("usuario", new UsuarioEntity()); // Añade una nueva instancia de Ruta al modelo
//        return "registrate"; // Retorna el nombre de la vista que contiene el formulario
//    }

//	@PostMapping("/registrate")
//	public String guardarUsuario(@ModelAttribute UsuarioEntity usuario, Model model) {
//	    if (usuarioService.existsByUsername(usuario.getUsuario())) {
//	        model.addAttribute("errorUsername", "El nombre de usuario ya está en uso");
//	        return "registrate"; // Retorna a la página de registro para mostrar el error
//	    }
//
//	    if (usuarioService.existsByEmail(usuario.getEmail())) {
//	        model.addAttribute("errorEmail", "El correo electrónico ya está en uso");
//	        return "registrate"; // Retorna a la página de registro para mostrar el error
//	    }
//	    
//	    if (usuarioService.existsByEmail(usuario.getEmail()) && usuarioService.existsByUsername(usuario.getUsuario())) {
//	    	model.addAttribute("errorEmail", "El correo electrónico y el usuario están en uso");
//	    	return "registrate"; // Retorna a la pagina de registro para mostrar el error
//	    }
//	    usuarioService.guardarUsuario(usuario);
//	    model.addAttribute("registroCorrecto", usuario.getNombre() + ", tu usuario ha sido registrado con éxito");
//	    return "registrate"; // Redirige a la lista de usuarios si no hay errores
//	}
//}
