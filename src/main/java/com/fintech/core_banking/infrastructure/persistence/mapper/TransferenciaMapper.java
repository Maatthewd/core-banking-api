package com.fintech.core_banking.infrastructure.persistence.mapper;

import com.fintech.core_banking.domain.model.entity.Transferencia;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.CuentaEntity;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.TransferenciaEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMapper {

    public TransferenciaEntity toEntity(
            Transferencia domain,
            CuentaEntity cuentaOrigenEntity,
            CuentaEntity cuentaDestinoEntity
    ) {
        if (domain == null) return null;

        return TransferenciaEntity.builder()
                .cuentaOrigen(cuentaOrigenEntity)
                .cuentaDestino(cuentaDestinoEntity)
                .importe(domain.getImporte().getMonto())
                .moneda(domain.getImporte().getMoneda())
                .fecha(domain.getFecha())
                .estado(domain.getEstado())
                .referencia(domain.getReferencia())
                .build();
    }

    public void updateEntity(Transferencia domain, TransferenciaEntity entity) {
        entity.setEstado(domain.getEstado());
    }
}
