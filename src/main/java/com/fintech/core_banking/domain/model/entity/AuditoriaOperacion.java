package com.fintech.core_banking.domain.model.entity;

import java.time.LocalDateTime;

public class AuditoriaOperacion {

    private String tipoOperacion;
    private Usuario usuario;
    private LocalDateTime fecha;
    private String resultado;

    // getters

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public String getResultado() {
        return resultado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}

