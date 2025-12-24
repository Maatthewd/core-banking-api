package com.fintech.core_banking.infrastructure.persistence.mapper;

import com.fintech.core_banking.domain.model.entity.Usuario;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;

        Usuario usuario = new Usuario();
        usuario.setUsername(entity.getUsername());
        usuario.setPassword(entity.getPassword());
        usuario.setRol(entity.getRol());
        usuario.setActivo(entity.getActivo());
        return usuario;
    }

    public UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;

        return UsuarioEntity.builder()
                .username(domain.getUsername())
                .password(domain.getPassword())
                .rol(domain.getRol())
                .activo(domain.getActivo())
                .build();
    }

    public void updateEntity(Usuario domain, UsuarioEntity entity) {
        entity.setPassword(domain.getPassword());
        entity.setRol(domain.getRol());
        entity.setActivo(domain.getActivo());
    }
}
