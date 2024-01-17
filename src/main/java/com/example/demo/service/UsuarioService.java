package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioServicio{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> buscarTodosUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        return usuarioRepository.buscarUsuarioPorUsername(username).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) {
        return usuarioRepository.buscarUsuarioPorCorreo(correo).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
