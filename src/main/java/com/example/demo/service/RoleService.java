package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> obtenerTodosRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role buscarRolePorId(Integer idRole) {
        return roleRepository.findById(idRole).orElse(null);
    }
}
