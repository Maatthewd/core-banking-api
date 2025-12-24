package com.fintech.core_banking.domain.model.valueObject;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Email {

    @Column(name = "email", nullable = false, length = 100)
    private String valor;

    protected Email(){}

    public Email(String valor) {
        if (!valor.matches(".+@.+\\..+")) {
            throw new IllegalArgumentException("Email inválido");
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
        Email email = (Email) o;
        return Objects.equals(valor, email.valor);
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

