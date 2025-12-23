package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import com.fintech.core_banking.domain.model.TipoParametro;
import jakarta.persistence.*;

@Table(name = "parametros_sistema")
@Entity
public class ParametroSistemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoParametro tipoParametro;

    @Column(nullable = false)
    private boolean activo;


}
