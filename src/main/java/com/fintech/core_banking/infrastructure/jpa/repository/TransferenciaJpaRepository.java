package com.fintech.core_banking.infrastructure.jpa.repository;

import com.fintech.core_banking.infrastructure.jpa.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransferenciaJpaRepository extends JpaRepository<TransferenciaEntity, Long> {

    Optional<TransferenciaEntity> findByReferencia(String referencia);

}
