package com.hristbartra.springsecurity.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hristbartra.springsecurity.controller.model.UsuarioEntity;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{

	public UsuarioEntity findByUsername(String username);
	
	@Query("select u from UsuarioEntity u where u.username=?1")
	public UsuarioEntity findByUsername2(String username);
}
