package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.entity.AuditoriaOperacion;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditoriaOperacionRepository {

    void save(AuditoriaOperacion auditoria);

    List<AuditoriaOperacion> findByUsuario(String username);

    List<AuditoriaOperacion> findByOperacion(String tipoOperacion);

    List<AuditoriaOperacion> findByRangoFechas(
            LocalDateTime desde,
            LocalDateTime hasta
    );


}
