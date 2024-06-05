package com.asturutas.spring.web.app.service.impl;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.entity.UsuarioEntity;
import com.asturutas.spring.web.app.repository.UsuarioRepository;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
   
    @Autowired
    private UsuarioRepository usuarioRepository;
   
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuario1 = usuarioRepository.findById(usuario);
        if(usuario1.isPresent()) {
            return usuario1.get();
        }
        throw new UsernameNotFoundException(usuario);
    }

}