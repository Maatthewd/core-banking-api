package com.fintech.core_banking.domain.exception;

public class ClienteNoEncontradoException extends DomainException {
    public ClienteNoEncontradoException(String documento) {
        super("No se encontró el cliente con documento: " + documento);
    }
}
