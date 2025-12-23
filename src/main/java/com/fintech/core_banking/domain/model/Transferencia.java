package com.fintech.core_banking.domain.model;

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
