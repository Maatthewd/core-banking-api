package com.fintech.core_banking.domain.model.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Dinero {

    @Column(name = "monto", nullable = false, precision = 15, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "moneda", nullable = false, length = 3)
    private Moneda moneda;

    protected Dinero() {
    }

    public Dinero(BigDecimal monto, Moneda moneda) {
        if (monto == null || monto.signum() < 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        if (moneda == null) {
            throw new IllegalArgumentException("Moneda no puede ser nula");
        }
        this.monto = monto;
        this.moneda = moneda;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public Moneda getMoneda() {
        return moneda;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinero dinero = (Dinero) o;
        return monto.compareTo(dinero.monto) == 0 && moneda == dinero.moneda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monto, moneda);
    }

    @Override
    public String toString() {
        return moneda + " " + monto;
    }

}

