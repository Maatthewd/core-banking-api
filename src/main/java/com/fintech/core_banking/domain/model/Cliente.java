package com.fintech.core_banking.domain.model;

import java.util.List;
import java.util.Set;


public class Cliente {

    private String documento;
    private String nombre;
    private TipoCliente tipoCliente;
    private String email;
    private EstadoCliente estado;

    private List<Cuenta> cuentas;

}
