package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.RolUsuario;

public class Usuario {

    private String username;
    private String password;
    private RolUsuario rol;
    private Boolean activo;


    // Constructor para crear nuevos usuarios
    public Usuario(String username, String password, RolUsuario rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.activo = true;
    }

    // Factory method para reconstruir desde BD
    public static Usuario reconstruir(
            String username,
            String password,
            RolUsuario rol,
            Boolean activo
    ) {
        Usuario usuario = new Usuario(username, password, rol);
        usuario.activo = activo;
        return usuario;
    }


    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    // Lógica de negocio
    public void cambiarPassword(String nuevoPassword) {
        if (nuevoPassword == null || nuevoPassword.length() < 8) {
            throw new IllegalArgumentException("Password debe tener al menos 8 caracteres");
        }
        this.password = nuevoPassword;
    }

    public void cambiarRol(RolUsuario nuevoRol) {
        if (nuevoRol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo");
        }
        this.rol = nuevoRol;
    }

    public void activar() {
        this.activo = true;
    }

    public void desactivar() {
        this.activo = false;
    }

    public boolean isActivo() {
        return activo != null && activo;
    }

    public boolean isAdmin() {
        return rol == RolUsuario.ADMIN;
    }

    public boolean isOperador() {
        return rol == RolUsuario.OPERADOR;
    }

    public boolean isCliente() {
        return rol == RolUsuario.CLIENTE;
    }
}
