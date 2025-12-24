package com.fintech.core_banking.domain.exception;

public class CuentaNoEncontradaException extends DomainException {
    public CuentaNoEncontradaException(String numeroCuenta) {
        super("No se encontró la cuenta: " + numeroCuenta);
    }
}
