package com.fintech.core_banking.infrastructure.jpa.entity;

import com.fintech.core_banking.domain.model.EstadoTransferencia;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.Moneda;
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

    @Column(nullable = false, unique = true, length = 50)
    private String referencia;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_origen_id", nullable = false)
    private CuentaEntity cuentaOrigen;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_destino_id", nullable = false)
    private CuentaEntity cuentaDestino;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "monto", column = @Column(name = "importe", nullable = false, precision = 15, scale = 2)),
        @AttributeOverride(name = "moneda", column = @Column(name = "moneda", nullable = false, length = 3))
    })
    private Dinero importe;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoTransferencia estado;

}