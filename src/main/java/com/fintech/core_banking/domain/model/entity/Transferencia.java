package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;
import com.fintech.core_banking.domain.model.valueObject.Dinero;

import java.time.LocalDateTime;

public class Transferencia {

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Dinero importe;
    private LocalDateTime fecha;
    private EstadoTransferencia estadoTransferencia;

    private String referencia;

}
