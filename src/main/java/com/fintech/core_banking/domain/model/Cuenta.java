package com.fintech.core_banking.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class Cuenta {

    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private EstadoCuenta estadoCuenta;
    private BigDecimal saldo;

}
