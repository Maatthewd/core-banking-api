package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    Optional<Usuario> findByUsername(String username);

    Usuario save(Usuario usuario);

    boolean existsByUsername(String username);
}
