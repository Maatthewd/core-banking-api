package com.fintech.core_banking.infrastructure.persistence.jpa.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencias", indexes = {
    @Index(name = "idx_transferencia_referencia", columnList = "referencia"),
    @Index(name = "idx_transferencia_fecha", columnList = "fecha")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_origen_id", nullable = false)
    private CuentaEntity cuentaOrigen;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_destino_id", nullable = false)
    private CuentaEntity cuentaDestino;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal importe;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoTransferencia estado;

    @Column(nullable = false, unique = true, length = 50)
    private String referencia;
}