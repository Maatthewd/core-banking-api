
package com.fintech.core_banking.infrastructure.jpa.mapper;

import com.fintech.core_banking.domain.model.entity.Cliente;
import com.fintech.core_banking.domain.model.valueObject.Documento;
import com.fintech.core_banking.domain.model.valueObject.Email;
import com.fintech.core_banking.infrastructure.jpa.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toDomain(ClienteEntity entity) {
        if (entity == null) return null;

        return Cliente.reconstruir(
            entity.getDocumento(),
            entity.getNombre(),
            entity.getTipo(),
            entity.getEmail(),
            entity.getEstado(),
            null // Las cuentas se cargan aparte para evitar ciclos
        );
    }

    public ClienteEntity toEntity(Cliente domain) {
        if (domain == null) return null;

        return ClienteEntity.builder()
            .documento(domain.getDocumento())
            .nombre(domain.getNombre())
            .tipo(domain.getTipoCliente())
            .email(domain.getEmail())
            .estado(domain.getEstado())
            .build();
    }

    public void updateEntity(Cliente domain, ClienteEntity entity) {
        entity.setNombre(domain.getNombre());
        entity.setEmail(domain.getEmail());
        entity.setEstado(domain.getEstado());
    }
}

