package com.fintech.core_banking.domain.model.valueObject;

public class NumeroCuenta {

    private final String valor;

    public NumeroCuenta(String valor) {
        if (!valor.matches("\\d{10,20}")) {
            throw new IllegalArgumentException("Número de cuenta inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

