package com.example.demo.service;

import com.example.demo.model.Usuario;

import java.util.List;

public interface IUsuarioServicio {

    List<Usuario> buscarTodosUsuarios();

    Usuario buscarUsuarioPorId(Integer idUsuario);

    Usuario buscarUsuarioPorUsername(String username);

    Usuario buscarUsuarioPorCorreo(String correo);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Integer idUsuario);
}
