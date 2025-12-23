package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "auditoria_operaciones")
@Entity
public class AuditoriaOperacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoOperacion;

    @ManyToOne(optional = false, targetEntity = UsuarioEntity.class)
    private UsuarioEntity usuario;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String resultado;

}
