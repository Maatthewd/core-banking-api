package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;
import com.fintech.core_banking.domain.model.valueObject.Dinero;

import java.time.LocalDateTime;

public class Transferencia {

    private String referencia;

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Dinero importe;
    private LocalDateTime fecha;
    private EstadoTransferencia estado;


    public LocalDateTime getFecha() {
        return fecha;
    }

    public Dinero getImporte() {
        return importe;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public EstadoTransferencia getEstado() {
        return estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }


    public void setEstado(EstadoTransferencia estado) {
        this.estado = estado;
    }
}
