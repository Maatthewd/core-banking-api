package com.fintech.core_banking.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria_operaciones", indexes = {
    @Index(name = "idx_auditoria_usuario", columnList = "usuario_id"),
    @Index(name = "idx_auditoria_fecha", columnList = "fecha"),
    @Index(name = "idx_auditoria_operacion", columnList = "tipo_operacion")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditoriaOperacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String tipoOperacion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 50)
    private String resultado;

    @Column(length = 1000)
    private String detalles;
}
