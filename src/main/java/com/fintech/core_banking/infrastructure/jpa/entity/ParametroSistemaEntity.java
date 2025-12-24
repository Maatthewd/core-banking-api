package com.fintech.core_banking.infrastructure.jpa.entity;

import com.fintech.core_banking.domain.model.TipoParametro;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "parametros_sistema", indexes = {
    @Index(name = "idx_parametro_clave", columnList = "clave")
})
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametroSistemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String clave;

    @Column(nullable = false, length = 500)
    private String valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoParametro tipo;

    @Column(nullable = false)
    private Boolean activo;

    @Column(length = 500)
    private String descripcion;
}