package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movimiento {

    private TipoMovimiento tipoMovimiento;
    private Dinero importe;
    private LocalDateTime fecha;
    private String descripcion;
    private Dinero saldoPosterior;

    private Cuenta cuenta;

    public Movimiento(
            TipoMovimiento tipoMovimiento,
            Dinero importe,
            String descripcion,
            Cuenta cuenta
    ){
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
        this.saldoPosterior = cuenta.getSaldo();
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.cuenta = cuenta;
    }


}
