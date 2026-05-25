package com.vetnova_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova_usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByCorreo(String correo);
    boolean existsByRut(String rut);
    boolean existsByTelefono(String telefono);

}
