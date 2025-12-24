package com.fintech.core_banking.infrastructure.jpa.mapper;

import com.fintech.core_banking.domain.model.entity.AuditoriaOperacion;
import com.fintech.core_banking.infrastructure.jpa.entity.AuditoriaOperacionEntity;
import com.fintech.core_banking.infrastructure.jpa.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaOperacionMapper {

    public AuditoriaOperacionEntity toEntity(
            AuditoriaOperacion domain,
            UsuarioEntity usuarioEntity
    ) {
        if (domain == null) return null;

        return AuditoriaOperacionEntity.builder()
                .tipoOperacion(domain.getTipoOperacion())
                .usuario(usuarioEntity)
                .fecha(domain.getFecha())
                .resultado(domain.getResultado())
                .build();
    }
}
