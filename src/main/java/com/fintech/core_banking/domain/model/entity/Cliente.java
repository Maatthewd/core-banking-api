package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoCliente;
import com.fintech.core_banking.domain.model.TipoCliente;

import java.util.List;


public class Cliente {

    private String documento;
    private String nombre;
    private TipoCliente tipoCliente;
    private String email;
    private EstadoCliente estado;

    private List<Cuenta> cuentas;

}
