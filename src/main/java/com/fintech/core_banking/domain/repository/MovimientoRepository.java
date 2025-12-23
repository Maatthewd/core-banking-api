package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.Movimiento;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository {

    void save(Movimiento movimiento);

    List<Movimiento> findByNumeroCuenta(String numeroCuenta);

    List<Movimiento> findByNumeroCuentaYRangoFechas(
            String numeroCuenta,
            LocalDateTime desde,
            LocalDateTime hasta
    );

}
