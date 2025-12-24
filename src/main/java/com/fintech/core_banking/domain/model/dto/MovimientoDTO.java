package com.fintech.core_banking.domain.model.dto;

import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public record MovimientoDTO(
        Long id,
        TipoMovimiento tipo,
        Dinero importe,
        LocalDateTime fecha,
        String descripcion,
        Dinero saldoPosterior
) {
}

