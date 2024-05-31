package com.asturutas.spring.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asturutas.spring.web.app.service.ActividadService;

@Controller
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private ActividadService actividadService;
	
	

}
