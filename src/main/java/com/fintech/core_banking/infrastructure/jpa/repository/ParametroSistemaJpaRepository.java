package com.fintech.core_banking.infrastructure.jpa.repository;

import com.fintech.core_banking.infrastructure.jpa.entity.ParametroSistemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametroSistemaJpaRepository extends JpaRepository<ParametroSistemaEntity, Long> {

    Optional<ParametroSistemaEntity> findByClave(String clave);

}
