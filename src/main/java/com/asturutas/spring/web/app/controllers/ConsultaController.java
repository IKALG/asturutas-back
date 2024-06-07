package com.asturutas.spring.web.app.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asturutas.spring.web.app.dto.consulta.ConsultaRequestDto;
import com.asturutas.spring.web.app.dto.consulta.ConsultaResponseDto;
import com.asturutas.spring.web.app.service.ConsultaService;

@Controller
@RequestMapping("/contacto")
public class ConsultaController {

    @Autowired 
    private ConsultaService consultaService;

    @GetMapping
    public String create(Model model) {
        model.addAttribute("consultaRequestDto", new ConsultaRequestDto());
        return "contacto";
    }

    @PostMapping
    public String save(@ModelAttribute("consultaRequestDto") ConsultaRequestDto consultaRequestDto, Model model) {
        consultaService.create(consultaRequestDto);
        return "redirect:/contacto?success";
    }
    
    @GetMapping("mostrar/consultas")
    public String findAll(Model model, Principal principal) {
		List<ConsultaResponseDto> consultas = consultaService.findAll();
	    model.addAttribute("user", principal != null ? principal.getName() : null);
		model.addAttribute("consultas", consultas);
		return "mostrar-consultas";
    }
}
