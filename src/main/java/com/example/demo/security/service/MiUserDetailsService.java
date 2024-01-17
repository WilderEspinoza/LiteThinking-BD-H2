package com.example.demo.security.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MiUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<Usuario> usuario = usuarioRepository.buscarUsuarioPorUsername(username);
        usuario.orElseThrow( () -> new UsernameNotFoundException("Nose encontro el usuario " + username + "en BD"));
        return usuario.map(MiUserDetails::new).get();
    }
}
