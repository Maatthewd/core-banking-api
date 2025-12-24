package com.fintech.core_banking.domain.model.valueObject;

import java.util.Objects;

public class NumeroCuenta {

    private final String valor;

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
}

