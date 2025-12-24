package com.fintech.core_banking.infrastructure.persistence.mapper;

import com.fintech.core_banking.domain.model.entity.Movimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.infrastructure.persistence.dto.MovimientoDTO;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.CuentaEntity;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.MovimientoEntity;
import org.springframework.stereotype.Component;

@Component
public class MovimientoMapper {

    public MovimientoEntity toEntity(Movimiento domain, CuentaEntity cuentaEntity) {
        if (domain == null) return null;

        return MovimientoEntity.builder()
                .tipo(domain.getTipoMovimiento())
                .importe(domain.getImporte().getMonto())
                .monedaImporte(domain.getImporte().getMoneda())
                .fecha(domain.getFecha())
                .descripcion(domain.getDescripcion())
                .saldoPosterior(domain.getSaldoPosterior().getMonto())
                .monedaSaldo(domain.getSaldoPosterior().getMoneda())
                .cuenta(cuentaEntity)
                .build();
    }

    public MovimientoDTO toDTO(MovimientoEntity entity) {
        if (entity == null) return null;

        return new MovimientoDTO(
                entity.getId(),
                entity.getTipo(),
                new Dinero(entity.getImporte(), entity.getMonedaImporte()),
                entity.getFecha(),
                entity.getDescripcion(),
                new Dinero(entity.getImporte(), entity.getMonedaSaldo())
        );
    }
}
