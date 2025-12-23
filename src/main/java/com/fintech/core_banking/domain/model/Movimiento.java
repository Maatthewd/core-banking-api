package com.fintech.core_banking.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimiento {

    private TipoMovimiento tipoMovimiento;
    private BigDecimal importe;
    private LocalDateTime fecha;
    private String descripcion;
    private BigDecimal saldoPosterior;

    private Cuenta cuenta;
}
