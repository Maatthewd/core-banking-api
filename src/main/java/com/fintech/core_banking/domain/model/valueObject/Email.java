package com.fintech.core_banking.domain.model.valueObject;

public class Email {

    private final String valor;

    public Email(String valor) {
        if (!valor.matches(".+@.+\\..+")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

