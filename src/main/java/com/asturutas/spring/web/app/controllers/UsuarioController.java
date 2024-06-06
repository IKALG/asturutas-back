package com.asturutas.spring.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.entity.UsuarioEntity;
import com.asturutas.spring.web.app.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {
   
    @Autowired
    private UsuarioService usuarioService;
 
    @GetMapping("/usuarios")
    public ModelAndView getUsuarios() {
        return usuarioService.getUsuarios();
    }
 
    @GetMapping("/usuario/add")
    public ModelAndView addUsuario() {
        return usuarioService.addUsuario();
    }
 
    @PostMapping("/usuario/save")
    public ModelAndView saveUsuario(@ModelAttribute("usuarioNuevo") @Valid UsuarioEntity usuarioNuevo,
            BindingResult bindingResult) {
        return usuarioService.saveUsuario(usuarioNuevo, bindingResult);
    }
 
    @GetMapping("/usuario/edit/{nombre}")
    public ModelAndView editUsuario(@PathVariable String nombre) {
        return usuarioService.editUsuario(nombre);
    }
 
    @GetMapping("/login")
    public ModelAndView login() {
        return usuarioService.login();
    }
 
    @PostMapping("/login")
    public ModelAndView loginUser(@ModelAttribute("user") UsuarioEntity user, HttpServletRequest request) {
        return usuarioService.loginUser(user,request);
    }
 
    @GetMapping("/register")
    public ModelAndView register() {
        return usuarioService.registrer();
    }
 
    @PostMapping("/register")
    public ModelAndView registerUser(@ModelAttribute("user") UsuarioEntity user) {
        return usuarioService.registrerUser(user);
    }
 
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        return usuarioService.logout(request);
    }
 
    @GetMapping("/home")
    public ModelAndView home(HttpServletRequest request) {
        return usuarioService.home(request);
    }

}