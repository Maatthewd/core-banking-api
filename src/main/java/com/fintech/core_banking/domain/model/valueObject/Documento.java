package com.fintech.core_banking.domain.model.valueObject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Documento {

    @Column(name = "documento", nullable = false, unique = true, length = 20)
    private String numero;

    protected Documento(){}

    public Documento(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Documento inválido");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(numero, documento.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return numero;
    }
}

