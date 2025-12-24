package com.fintech.core_banking.infrastructure.jpa.repository;

import com.fintech.core_banking.domain.model.entity.Cliente;
import com.fintech.core_banking.infrastructure.jpa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, Long>  {

    Optional<Cliente> findByDocumento(String documento);

    boolean existsByDocumento(String documento);
}
