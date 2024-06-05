package com.asturutas.spring.web.app.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	
	public UserDetails loadUserByUsername(String usuario);

}
