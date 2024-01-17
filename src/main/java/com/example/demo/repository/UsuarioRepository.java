package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.userName = ?1")
    Optional<Usuario> buscarUsuarioPorUsername(String userName);


    @Query("SELECT u FROM Usuario u WHERE u.correo = ?1")
    Optional<Usuario> buscarUsuarioPorCorreo(String correo);
}
