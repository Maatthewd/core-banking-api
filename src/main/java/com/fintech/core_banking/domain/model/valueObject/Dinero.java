package com.fintech.core_banking.domain.model.valueObject;

import java.math.BigDecimal;

public class Dinero {

    private final BigDecimal monto;
    private final Moneda moneda;

    public Dinero(BigDecimal monto, Moneda moneda) {
        if (monto == null || monto.signum() < 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        this.monto = monto;
        this.moneda = moneda;
    }

    public Dinero sumar(Dinero otro) {
        validarMoneda(otro);
        return new Dinero(monto.add(otro.monto), moneda);
    }

    public Dinero restar(Dinero otro) {
        validarMoneda(otro);
        if (monto.compareTo(otro.monto) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        return new Dinero(monto.subtract(otro.monto), moneda);
    }

    private void validarMoneda(Dinero otro) {
        if (!moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("Monedas incompatibles");
        }
    }
}

