package com.fintech.core_banking.domain.exception;

public class ClienteYaExisteException extends DomainException {
    public ClienteYaExisteException(String documento) {
        super("Ya existe un cliente con el documento: " + documento);
    }
}
