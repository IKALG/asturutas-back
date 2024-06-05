package com.asturutas.spring.web.app.service;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.entity.UsuarioEntity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface UsuarioService {
 
    ModelAndView getUsuarios();
 
    ModelAndView getUsuario(@PathVariable String dni);
 
    ModelAndView deleteUsuario(@PathVariable String nombre);
 
    ModelAndView addUsuario();
   
    ModelAndView saveUsuario(@ModelAttribute("usuarioNuevo") @Valid UsuarioEntity usuarioNuevo, BindingResult bindingResult);
 
    ModelAndView editUsuario(@PathVariable String dni);
 
    /* Gestion de sesiones: */
 
    UsuarioEntity findUserByUsuario(String usuario);
    void saveUser(UsuarioEntity user);
 
    ModelAndView login();
    ModelAndView loginUser(UsuarioEntity user,HttpServletRequest request);
    ModelAndView registrer();
    ModelAndView registrerUser(UsuarioEntity user);
    ModelAndView logout(HttpServletRequest request);
    ModelAndView home(HttpServletRequest request);
}