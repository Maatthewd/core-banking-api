package com.fintech.core_banking.domain.exception;

public class CuentaNoOperableException extends DomainException {
    public CuentaNoOperableException() {
        super("La cuenta no está disponible para operar");
    }

    public CuentaNoOperableException(String motivo) {
        super("La cuenta no está disponible para operar: " + motivo);
    }
}
