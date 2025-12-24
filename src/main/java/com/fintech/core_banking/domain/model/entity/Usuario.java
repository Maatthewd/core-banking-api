package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.RolUsuario;

public class Usuario {

    private String username;
    private String password;
    private RolUsuario rol;
    private Boolean activo;

    // getters

    public Boolean getActivo() {
        return activo;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
