package com.fintech.core_banking.domain.repository;


import com.fintech.core_banking.domain.model.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByDocumento(String documento);

    Cliente save(Cliente cliente);

    boolean existsByDocumento(String documento);
}
