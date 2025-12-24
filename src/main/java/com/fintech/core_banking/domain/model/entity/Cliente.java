package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.exception.ClienteInactivoException;
import com.fintech.core_banking.domain.model.EstadoCliente;
import com.fintech.core_banking.domain.model.TipoCliente;
import com.fintech.core_banking.domain.model.valueObject.Documento;
import com.fintech.core_banking.domain.model.valueObject.Email;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private Documento documento;
    private String nombre;
    private TipoCliente tipoCliente;
    private Email email;
    private EstadoCliente estado;
    private List<Cuenta> cuentas;

    // Constructor para crear nuevos clientes
    public Cliente(
            Documento documento,
            String nombre,
            TipoCliente tipoCliente,
            Email email
    ) {
        this.documento = documento;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.email = email;
        this.estado = EstadoCliente.ACTIVO;
        this.cuentas = new ArrayList<>();
    }

    // Constructor para reconstruir desde BD
    public static Cliente reconstruir(
            Documento documento,
            String nombre,
            TipoCliente tipoCliente,
            Email email,
            EstadoCliente estado,
            List<Cuenta> cuentas
    ) {
        Cliente cliente = new Cliente(documento, nombre, tipoCliente, email);
        cliente.estado = estado;
        cliente.cuentas = cuentas != null ? new ArrayList<>(cuentas) : new ArrayList<>();
        return cliente;
    }

    // Getters
    public Documento getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public Email getEmail() {
        return email;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public List<Cuenta> getCuentas() {
        return Collections.unmodifiableList(cuentas);
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    // Lógica de negocio
    public boolean isActivo() {
        return estado == EstadoCliente.ACTIVO;
    }

    public void activar() {
        this.estado = EstadoCliente.ACTIVO;
    }

    public void inactivar() {
        this.estado = EstadoCliente.INACTIVO;
        // Bloquear todas las cuentas del cliente
        cuentas.forEach(Cuenta::bloquear);
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (!isActivo()) {
            throw new ClienteInactivoException();
        }
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        this.cuentas.add(cuenta);
    }

    public boolean tieneCuentas() {
        return !cuentas.isEmpty();
    }

    public int cantidadCuentas() {
        return cuentas.size();
    }
}