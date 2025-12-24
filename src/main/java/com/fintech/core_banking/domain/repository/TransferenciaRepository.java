package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.entity.Transferencia;

import java.util.Optional;

public interface TransferenciaRepository {

    Optional<Transferencia> findById(Long id);

    Optional<Transferencia> findByReferencia(String referencia);

    Transferencia save(Transferencia transferencia);
}
