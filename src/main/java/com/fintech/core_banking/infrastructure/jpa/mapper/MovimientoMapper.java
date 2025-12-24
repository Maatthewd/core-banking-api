package com.fintech.core_banking.infrastructure.jpa.mapper;

import com.fintech.core_banking.domain.model.entity.Movimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.dto.MovimientoDTO;
import com.fintech.core_banking.infrastructure.jpa.entity.CuentaEntity;
import com.fintech.core_banking.infrastructure.jpa.entity.MovimientoEntity;
import org.springframework.stereotype.Component;

@Component
public class MovimientoMapper {

    public MovimientoEntity toEntity(Movimiento domain, CuentaEntity cuentaEntity) {
        if (domain == null) return null;

        return MovimientoEntity.builder()
                .tipo(domain.getTipoMovimiento())
                .importe(domain.getImporte())
                .fecha(domain.getFecha())
                .descripcion(domain.getDescripcion())
                .saldoPosterior(domain.getSaldoPosterior())
                .cuenta(cuentaEntity)
                .build();
    }

    public MovimientoDTO toDTO(MovimientoEntity entity) {
        if (entity == null) return null;

        return new MovimientoDTO(
                entity.getId(),
                entity.getTipo(),
                entity.getImporte(),
                entity.getFecha(),
                entity.getDescripcion(),
                entity.getImporte()
        );
    }
}
