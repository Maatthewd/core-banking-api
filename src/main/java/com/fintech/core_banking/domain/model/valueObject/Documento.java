package com.fintech.core_banking.domain.model.valueObject;

public class Documento {

    private final String numero;

    public Documento(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Documento inválido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}

