package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia {

    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private BigDecimal importe;
    private LocalDateTime fecha;
    private EstadoTransferencia estadoTransferencia;

    private String referencia;
}
