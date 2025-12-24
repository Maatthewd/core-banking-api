package com.fintech.core_banking.infrastructure.jpa.repository;

import com.fintech.core_banking.infrastructure.jpa.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaJpaRepository extends JpaRepository<CuentaEntity, Long> {

    Optional<CuentaEntity> findByNumero(String numero);

    List<CuentaEntity> findByClienteId(Long clienteId);

    boolean existsByNumero(String numero);
}
