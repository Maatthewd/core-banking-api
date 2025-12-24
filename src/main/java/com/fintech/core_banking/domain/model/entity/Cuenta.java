package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoCuenta;
import com.fintech.core_banking.domain.model.TipoCuenta;

import java.math.BigDecimal;
import java.util.List;

public class Cuenta {

    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private EstadoCuenta estadoCuenta;
    private BigDecimal saldo;

    private Cliente cliente;

    private List<Movimiento> movimientos;

}
