package com.vetnova_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova_usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
