package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import com.fintech.core_banking.domain.model.TipoMovimiento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "movimientos")
@Entity
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimiento tipo;

    @Column(nullable = false)
    private BigDecimal importe;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private BigDecimal saldoPosterior;



    @ManyToOne(optional = false)
    @JoinColumn(name = "cuenta_id")
    private CuentaEntity cuenta;

}
