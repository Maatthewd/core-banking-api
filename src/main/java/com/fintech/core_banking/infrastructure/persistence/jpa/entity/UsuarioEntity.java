package com.fintech.core_banking.infrastructure.persistence.jpa.entity;

import com.fintech.core_banking.domain.model.RolUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios", indexes = {
    @Index(name = "idx_usuario_username", columnList = "username")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RolUsuario rol;

    @Column(nullable = false)
    private Boolean activo;
}