package com.hristbartra.springsecurity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hristbartra.springsecurity.controller.model.UsuarioEntity;
import com.hristbartra.springsecurity.repository.IUsuarioRepository;

@Service("userDetailService")
public class UsuarioService implements UserDetailsService {

	private Logger logger =  LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = usuarioRepository.findByUsername(username);
		logger.info("00001"+username+" "+usuario.getUsername());
		if(usuario  == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authority = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(auth -> logger.info("Rol: "+ auth.getAuthority()))
				.collect(Collectors.toList());
		
		for(GrantedAuthority strg : authority ) {
			String rol =authority.toString();
			logger.info("Rol2: "+rol);
		}
	
		//return new User(username, usuario.getPassword(), true, true, true, true, authority);
		return User.withUsername(usuario.getUsername()).password(usuario.getPassword()).roles(authority.toString()).build();
	}

}
