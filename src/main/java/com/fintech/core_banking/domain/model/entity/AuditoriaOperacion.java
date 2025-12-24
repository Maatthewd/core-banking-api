package com.fintech.core_banking.domain.model.entity;

import java.time.LocalDateTime;

public class AuditoriaOperacion {

    private String tipoOperacion;
    private Usuario usuario;
    private LocalDateTime fecha;
    private String resultado;

    public AuditoriaOperacion(
            String tipoOperacion,
            Usuario usuario,
            String resultado
    ) {
        this.tipoOperacion = tipoOperacion;
        this.usuario = usuario;
        this.resultado = resultado;
        this.fecha = LocalDateTime.now();
    }

    // Getters
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }
}

