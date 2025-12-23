package com.fintech.core_banking.infrastructure.persistance.jpa.entity;

import com.fintech.core_banking.domain.model.RolUsuario;
import jakarta.persistence.*;

@Table(name = "usuarios")
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rolUsuario;

    @Column(nullable = false)
    private Boolean estado;
}
