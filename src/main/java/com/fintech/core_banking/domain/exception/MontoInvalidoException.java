package com.fintech.core_banking.domain.exception;

public class MontoInvalidoException extends DomainException {
    public MontoInvalidoException() {
        super("El monto debe ser mayor a cero");
    }
}
