package com.example.demo.security.service;

import com.example.demo.model.Role;
import com.example.demo.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MiUserDetails implements UserDetails {

    private String username;

    private String password;

    private boolean activo;

    private List<SimpleGrantedAuthority> authorites;

    public MiUserDetails(Usuario usuario) {
        this.authorites = new ArrayList<>();
        this.username = usuario.getUserName();
        this.password = usuario.getPassword();
        this.activo = usuario.isActivo();

        for (Role role : usuario.getRoles()){
            authorites.add(new SimpleGrantedAuthority("Role_" + role.getNombreRole()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.authorites;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername(){
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return this.activo;
    }
}
