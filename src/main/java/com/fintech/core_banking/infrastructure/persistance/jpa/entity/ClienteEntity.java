package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import com.fintech.core_banking.domain.model.Cuenta;
import com.fintech.core_banking.domain.model.EstadoCliente;
import com.fintech.core_banking.domain.model.TipoCliente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipo;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCliente estado;


    @OneToMany(mappedBy = "cliente")
    private List<CuentaEntity> cuentas;
}
