package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;

    private String nombreRole;

    private String descripcion;

    public Role() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNombreRole() {
        return nombreRole;
    }

    public void setNombreRole(String nombreRole) {
        this.nombreRole = nombreRole;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
