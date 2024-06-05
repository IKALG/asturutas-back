package com.asturutas.spring.web.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@ToString
public class UsuarioEntity implements UserDetails {

	@Column(name = "nombre")
	private String nombre;

	@Id
	@Column(name = "usuario")
	private String usuario;

	@Column(name = "email")
	private String email;

	@Column(name = "contrasena")
	private String password;

	@Column(name = "fechaCreacion")
	private Date fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private RolEntity rolEntity;

	public UsuarioEntity() {
	}

	public UsuarioEntity(String nombre, String usuario, String email, String password, Date fechaCreacion, RolEntity rolEntity) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.rolEntity = rolEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> permisos = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority permiso;
		if(this.getRolEntity().getId()==1) {
		permiso = new SimpleGrantedAuthority("ADMIN");
		}
		else if(this.getRolEntity().getId()==2) {
		permiso = new SimpleGrantedAuthority("AUTORIZADO");
		}
		else {
		permiso = new SimpleGrantedAuthority("USER");
		}
		permisos.add(permiso);
		return permisos;
		}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
