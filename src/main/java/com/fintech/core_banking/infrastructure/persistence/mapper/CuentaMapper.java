package com.fintech.core_banking.infrastructure.persistence.mapper;

import com.fintech.core_banking.domain.model.entity.Cliente;
import com.fintech.core_banking.domain.model.entity.Cuenta;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.NumeroCuenta;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.ClienteEntity;
import com.fintech.core_banking.infrastructure.persistence.jpa.entity.CuentaEntity;
import org.springframework.stereotype.Component;


@Component
public class CuentaMapper {

    private final ClienteMapper clienteMapper;

    public CuentaMapper(ClienteMapper clienteMapper) {
        this.clienteMapper = clienteMapper;
    }

    public Cuenta toDomain(CuentaEntity entity, Cliente cliente) {
        if (entity == null) return null;

        Dinero saldo = new Dinero(entity.getSaldo(), entity.getMoneda());

        return Cuenta.reconstruir(
                new NumeroCuenta(entity.getNumero()),
                entity.getTipo(),
                entity.getEstado(),
                saldo,
                cliente,
                null // Los movimientos se cargan aparte si se necesitan
        );
    }

    public CuentaEntity toEntity(Cuenta domain, ClienteEntity clienteEntity) {
        if (domain == null) return null;

        return CuentaEntity.builder()
                .numero(domain.getNumeroCuenta().getValor())
                .tipo(domain.getTipoCuenta())
                .estado(domain.getEstadoCuenta())
                .saldo(domain.getSaldo().getMonto())
                .moneda(domain.getSaldo().getMoneda())
                .cliente(clienteEntity)
                .build();
    }

    public void updateEntity(Cuenta domain, CuentaEntity entity) {
        entity.setEstado(domain.getEstadoCuenta());
        entity.setSaldo(domain.getSaldo().getMonto());
        entity.setMoneda(domain.getSaldo().getMoneda());
    }
}
