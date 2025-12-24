package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository {

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    List<Cuenta> findByClienteId(Long clienteId);

    Cuenta save(Cuenta cuenta);

    boolean existsByNumero(String numeroCuenta);
}
