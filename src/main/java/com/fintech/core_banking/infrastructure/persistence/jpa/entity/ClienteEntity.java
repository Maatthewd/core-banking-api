package com.fintech.core_banking.infrastructure.persistence.jpa.entity;

import com.fintech.core_banking.domain.model.EstadoCliente;
import com.fintech.core_banking.domain.model.TipoCliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes", indexes = {
    @Index(name = "idx_cliente_documento", columnList = "documento")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String documento;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoCliente tipo;

    @Column(nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoCliente estado;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<CuentaEntity> cuentas = new ArrayList<>();
}
