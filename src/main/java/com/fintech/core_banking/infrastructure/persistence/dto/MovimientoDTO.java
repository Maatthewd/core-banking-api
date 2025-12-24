package com.fintech.core_banking.infrastructure.persistence.dto;

import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;

import java.time.LocalDateTime;

public record MovimientoDTO(
        Long id,
        TipoMovimiento tipo,
        Dinero importe,
        LocalDateTime fecha,
        String descripcion,
        Dinero saldoPosterior
) {
}

