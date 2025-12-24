package com.fintech.core_banking.domain.exception;

public class SaldoInsuficienteException extends DomainException {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente para realizar la operación");
    }
}
