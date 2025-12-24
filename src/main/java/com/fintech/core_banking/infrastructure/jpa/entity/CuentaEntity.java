package com.fintech.core_banking.infrastructure.jpa.entity;

import com.fintech.core_banking.domain.model.EstadoCuenta;
import com.fintech.core_banking.domain.model.TipoCuenta;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.Moneda;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuentas", indexes = {
    @Index(name = "idx_cuenta_numero", columnList = "numero"),
    @Index(name = "idx_cuenta_cliente", columnList = "cliente_id")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoCuenta tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoCuenta estado;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "monto", column = @Column(name = "saldo", nullable = false, precision = 15, scale = 2)),
        @AttributeOverride(name = "moneda", column = @Column(name = "moneda", nullable = false, length = 3))
    })
    private Dinero saldo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MovimientoEntity> movimientos = new ArrayList<>();
}