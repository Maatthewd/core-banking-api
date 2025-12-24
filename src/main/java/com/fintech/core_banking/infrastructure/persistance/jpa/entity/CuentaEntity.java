package com.fintech.core_banking.infrastructure.persistance.jpa.entity;


import com.fintech.core_banking.domain.model.EstadoCuenta;
import com.fintech.core_banking.domain.model.TipoCuenta;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCuenta tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCuenta estado;

    @Column(nullable = false)
    private BigDecimal saldo;


    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "cuenta")
    private List<MovimientoEntity> movimientos;

}
