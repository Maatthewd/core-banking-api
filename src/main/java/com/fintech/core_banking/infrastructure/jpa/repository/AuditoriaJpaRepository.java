package com.fintech.core_banking.infrastructure.jpa.repository;

import com.fintech.core_banking.infrastructure.jpa.entity.AuditoriaOperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuditoriaJpaRepository extends JpaRepository<AuditoriaOperacionEntity, Long> {

    Optional<AuditoriaOperacionEntity> findByUsuarioUsername(String username);

    List<AuditoriaOperacionEntity> findByTipoOperacion(String tipoOperacion);

    @Query("SELECT a FROM AuditoriaOperacionEntity a WHERE a.fecha BETWEEN :desde AND :hasta ORDER BY a.fecha DESC")
    List<AuditoriaOperacionEntity> findByFechaBetween(
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta
    );
}
