package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.model.EstadoCuenta;
import com.fintech.core_banking.domain.model.TipoCuenta;
import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.Moneda;


import java.math.BigDecimal;
import java.util.List;

public class Cuenta {

    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private EstadoCuenta estadoCuenta;
    private Dinero saldo;
    private Moneda moneda;

    private Cliente cliente;

    private List<Movimiento> movimientos;

    public Cuenta(
            String numero,
            TipoCuenta tipo,
            EstadoCuenta estado,
            Moneda moneda,
            Cliente cliente
    ){
        this.numeroCuenta = numero;
        this.tipoCuenta = tipo;
        this.estadoCuenta = estado;
        this.saldo = new Dinero(BigDecimal.ZERO, moneda);
        this.moneda = moneda;
        this.cliente = cliente;
        this.movimientos = List.of();
    }

    public Dinero getSaldo() {
        return saldo;
    }

    public void depositar(Dinero monto) {
        validarActiva();
        validarMonto(monto);
        validarSaldo(monto);

        saldo = saldo.sumar(monto);
        registrarMovimiento(monto, TipoMovimiento.DEPOSITO, "");
    }

    public void extraer(Dinero monto){
        validarActiva();
        validarMonto(monto);
        validarSaldo(monto);

        saldo = saldo.restar(monto);
        registrarMovimiento(monto, TipoMovimiento.EXTRACCION, "");
    }

    public void transferir(Cuenta cuenta, Dinero monto) {
        cuenta.validarActiva();
        validarActiva();
        validarSaldo(monto);

        cuenta.depositar(monto);
        saldo = saldo.restar(monto);
        registrarMovimiento(monto, TipoMovimiento.TRANSFERENCIA, "");
    }

    public void bloquear(){
        estadoCuenta = EstadoCuenta.BLOQUEADA;
    }

    private void validarActiva(){
        if(this.estadoCuenta != EstadoCuenta.ACTIVA) {
            throw new RuntimeException("Cuenta no operable");
        }
    }

    private void validarSaldo(Dinero monto) {
        if(monto.getMonto().compareTo(this.saldo.getMonto()) > 0){
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    private void validarMonto(Dinero monto){
        if(monto.getMonto().compareTo(BigDecimal.ZERO) >= 0) {
            throw new RuntimeException("Monto inválido");
        }
    }

    private void registrarMovimiento(Dinero monto, TipoMovimiento tipo, String descripcion){
        Movimiento movimiento = new Movimiento(tipo, monto, descripcion, this);
        movimientos.add(movimiento);
    }

}
