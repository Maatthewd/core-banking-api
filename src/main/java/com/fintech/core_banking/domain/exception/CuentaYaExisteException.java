package com.fintech.core_banking.domain.exception;

public class CuentaYaExisteException extends DomainException {
    public CuentaYaExisteException(String numeroCuenta) {
        super("Ya existe una cuenta con el número: " + numeroCuenta);
    }
}
