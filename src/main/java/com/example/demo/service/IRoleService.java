package com.example.demo.service;

import com.example.demo.model.Role;

import java.util.List;

public interface IRoleService {

    List<Role> obtenerTodosRoles();

    Role buscarRolePorId(Integer idRole);
}
