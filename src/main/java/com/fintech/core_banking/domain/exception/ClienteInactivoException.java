package com.fintech.core_banking.domain.exception;

public class ClienteInactivoException extends DomainException {
    public ClienteInactivoException() {
        super("El cliente no está activo");
    }
}
