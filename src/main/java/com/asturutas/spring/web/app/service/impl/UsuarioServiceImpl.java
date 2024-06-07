package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;
import com.asturutas.spring.web.app.entity.UsuarioEntity;
import com.asturutas.spring.web.app.mapper.UsuarioMapper;
import com.asturutas.spring.web.app.repository.RolRepository;
import com.asturutas.spring.web.app.repository.UsuarioRepository;
import com.asturutas.spring.web.app.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Autowired
	private BCryptPasswordEncoder encriptador;

	@Override
	public ModelAndView getUsuarios() {

		ModelAndView model = new ModelAndView();
		model.addObject("usuarios", usuarioRepository.findAll());
		model.setViewName("mostrar-usuarios");

		return model;
	}

	@Override
	public ModelAndView getUsuario(String nombre) {

		UsuarioEntity usuario = usuarioRepository.findById(nombre).get();
		ModelAndView model = new ModelAndView();
		model.setViewName("usuarioHTML/usuario");
		model.addObject("usuario", usuario);

		return model;
	}

	@Override
	public ModelAndView deleteUsuario(String nombre) {

		ModelAndView model = new ModelAndView();

		Optional<UsuarioEntity> usuario = usuarioRepository.findById(nombre);
		if (usuario.isPresent()) {
			usuarioRepository.deleteById(nombre);
		}
		model.setViewName("redirect:/usuarios");

		return model;
	}

	@Override
	public ModelAndView addUsuario() {

		ModelAndView model = new ModelAndView();
		model.addObject("usuarioNuevo", new UsuarioEntity());
		model.addObject("roles", rolRepository.findAll());
		model.setViewName("registrate");

		return model;
	}

	@Override
	public ModelAndView saveUsuario(UsuarioEntity usuarioNuevo, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();

		if (bindingResult.hasErrors()) {
			model.setViewName("registrate");
			return model;
		}
		usuarioNuevo.setPassword(encriptador.encode(usuarioNuevo.getPassword()));
		usuarioRepository.save(usuarioNuevo);
		model.setViewName("redirect:/usuarios");

		return model;
	}

	@Override
	public ModelAndView editUsuario(String nombre) {

		ModelAndView model = new ModelAndView();
		Optional<UsuarioEntity> jugOpt = usuarioRepository.findById(nombre);

		if (jugOpt.isPresent()) {
			UsuarioEntity usuario = jugOpt.get();
			model.addObject("usuarioNuevo", usuario);
			model.addObject("roles", rolRepository.findAll());
			model.setViewName("usuarioHTML/usuarioForm");
		} else {
			model.setViewName("redirect:/usuarios");
		}

		return model;
	}

	@Override
	public UsuarioEntity findUserByUsuario(String usuario) {
		return usuarioRepository.findById(usuario).get();
	}

	@Override
	public void saveUser(UsuarioEntity user) {
		user.setPassword(encriptador.encode(user.getPassword()));
		usuarioRepository.save(user);
	}

	@Override
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("user", new UsuarioEntity());
		return modelAndView;
	}

	@Override
	public ModelAndView loginUser(UsuarioEntity user, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<UsuarioEntity> existingUserOptional = usuarioRepository.findById(user.getUsuario());
		if (existingUserOptional.isPresent()) {
			UsuarioEntity existingUser = existingUserOptional.get();
			if (encriptador.matches(user.getPassword(), existingUser.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("user", existingUser);
				modelAndView.setViewName("redirect:/");
			} else {
				modelAndView.addObject("message", "Invalid username or password");
				modelAndView.setViewName("login");
			}
		} else {
			modelAndView.addObject("message", "User not found");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@Override
	public ModelAndView registrer() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registrate");
		modelAndView.addObject("user", new UsuarioEntity());
		return modelAndView;
	}

	@Override
	public ModelAndView registrerUser(UsuarioEntity user) {
		ModelAndView modelAndView = new ModelAndView();

		Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findById(user.getUsuario());
		if (!usuarioOptional.isPresent()) {
			user.setRolEntity(rolRepository.findById((int) 2).get());
			user.setPassword(encriptador.encode(user.getPassword()));
			usuarioRepository.save(user);
		} else {
			modelAndView.addObject("message", "El usuario ya existe");
			modelAndView.setViewName("registrate");
			return modelAndView;
		}

		modelAndView.addObject("message", "User has been registered successfully");
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@Override
	public ModelAndView logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@Override
	public ModelAndView home(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			modelAndView.setViewName("index");
		} else {
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@Override
	public UsuarioResponseDto findByUsuario(String usuario) {
		Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findByUsuario(usuario);
		if (optionalUsuarioEntity.isPresent()) {
			UsuarioResponseDto usuarioResponseDto = usuarioMapper
					.entityToUsuarioResponseDto(optionalUsuarioEntity.get());
			return usuarioResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una usuario con el id: " + usuario);
		}
	}
	
	public UsuarioResponseDto delete(String usuario) {
		UsuarioResponseDto usuarioResponseDto = this.findByUsuario(usuario);
		UsuarioEntity usuarioEntity = usuarioMapper.responseDtoToEntity(usuario, usuarioResponseDto);
		usuarioRepository.delete(usuarioEntity);
		return usuarioResponseDto;
	}

	@Override
	public List<UsuarioResponseDto> findAll() {
		List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
		if (usuarioEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<UsuarioResponseDto> usuarioResponseDtoList = new ArrayList<>();
			for (UsuarioEntity usuarioEntity : usuarioEntityList) {
				UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToUsuarioResponseDto(usuarioEntity);
				usuarioResponseDtoList.add(usuarioResponseDto);
			}
			return usuarioResponseDtoList;
		}
	}
}
