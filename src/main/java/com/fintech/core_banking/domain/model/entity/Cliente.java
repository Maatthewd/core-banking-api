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

    // getters
    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getEmail() {
        return email;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }


    //

    public boolean isActivo(){
        return estado.equals(EstadoCliente.ACTIVO);
    }


}
