
package com.fintech.core_banking.infrastructure.persistence.mapper;

import com.fintech.core_banking.domain.model.entity.Cliente;
import com.fintech.core_banking.domain.model.valueObject.Documento;
import com.fintech.core_banking.domain.model.valueObject.Email;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toDomain(ClienteEntity entity) {
        if (entity == null) return null;

        return Cliente.reconstruir(
            new Documento(entity.getDocumento()),
            entity.getNombre(),
            entity.getTipo(),
            new Email(entity.getEmail()),
            entity.getEstado(),
            null // Las cuentas se cargan aparte para evitar ciclos
        );
    }

    public ClienteEntity toEntity(Cliente domain) {
        if (domain == null) return null;

        return ClienteEntity.builder()
            .documento(domain.getDocumento().getNumero())
            .nombre(domain.getNombre())
            .tipo(domain.getTipoCliente())
            .email(domain.getEmail().getValor())
            .estado(domain.getEstado())
            .build();
    }

    public void updateEntity(Cliente domain, ClienteEntity entity) {
        entity.setNombre(domain.getNombre());
        entity.setEmail(domain.getEmail().getValor());
        entity.setEstado(domain.getEstado());
    }
}

