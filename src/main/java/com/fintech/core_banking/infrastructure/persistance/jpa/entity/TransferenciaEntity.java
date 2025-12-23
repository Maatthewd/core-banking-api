package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transferencias")
@Entity
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private CuentaEntity cuentaOrigen;

    @Column(nullable = false)
    private CuentaEntity cuentaDestino;

    @Column(nullable = false)
    private BigDecimal importe;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTransferencia estadoTransferencia;

    @Column(nullable = false)
    private String referencia;


}
