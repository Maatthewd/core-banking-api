package com.fintech.core_banking.domain.model.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class NumeroCuenta {

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    private String valor;

    protected NumeroCuenta(){}

    public NumeroCuenta(String valor) {
        if (valor == null || !valor.matches("\\d{10,20}")) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumeroCuenta that = (NumeroCuenta) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor;
    }
}

