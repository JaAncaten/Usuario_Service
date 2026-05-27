package com.vetnova_usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova_usuario.model.Usuario;
import com.vetnova_usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

        public Usuario crearPerfilBasico(Usuario usuario) {
        usuario.setEstado("ACTIVO");
        return usuarioRepository.save(usuario);
    }
    

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())){
            return null;
        }

        if (usuarioRepository.existsByRut(usuario.getRut())){
            return null;
        }

        if (usuarioRepository.existsByTelefono(usuario.getTelefono())){
            return null;
        }

        return usuarioRepository.save(usuario); 
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();

            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setPassword(usuarioActualizado.getPassword());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setRol(usuarioActualizado.getRol());

            return usuarioRepository.save(usuario);
        }

        return null;
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }

        return false;
    }
}