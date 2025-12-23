package com.fintech.core_banking.domain.repository;

import com.fintech.core_banking.domain.model.ParametroSistema;

import java.util.Optional;

public interface ParametroSistemaRepository {

    Optional<ParametroSistema> FindByClave(String clave);
}
