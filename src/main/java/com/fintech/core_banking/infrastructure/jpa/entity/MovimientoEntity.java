package com.fintech.core_banking.infrastructure.jpa.entity;

import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.Moneda;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos", indexes = {
    @Index(name = "idx_movimiento_cuenta", columnList = "cuenta_id"),
    @Index(name = "idx_movimiento_fecha", columnList = "fecha")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoMovimiento tipo;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "monto", column = @Column(name = "importe", nullable = false, precision = 15, scale = 2)),
        @AttributeOverride(name = "moneda", column = @Column(name = "moneda_importe", nullable = false, length = 3))
    })
    private Dinero importe;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "monto", column = @Column(name = "saldo_posterior", nullable = false, precision = 15, scale = 2)),
        @AttributeOverride(name = "moneda", column = @Column(name = "moneda_saldo", nullable = false, length = 3))
    })
    private Dinero saldoPosterior;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private CuentaEntity cuenta;
}