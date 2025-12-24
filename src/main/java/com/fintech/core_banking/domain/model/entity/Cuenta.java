package com.fintech.core_banking.domain.model.entity;

import com.fintech.core_banking.domain.exception.*;
import com.fintech.core_banking.domain.model.EstadoCuenta;
import com.fintech.core_banking.domain.model.TipoCuenta;
import com.fintech.core_banking.domain.model.TipoMovimiento;
import com.fintech.core_banking.domain.model.valueObject.Dinero;
import com.fintech.core_banking.domain.model.valueObject.Moneda;
import com.fintech.core_banking.domain.model.valueObject.NumeroCuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cuenta {

    private NumeroCuenta numeroCuenta;
    private TipoCuenta tipoCuenta;
    private EstadoCuenta estadoCuenta;
    private Dinero saldo;
    private Cliente cliente;
    private List<Movimiento> movimientos;

    // Constructor para crear nuevas cuentas
    public Cuenta(
            NumeroCuenta numeroCuenta,
            TipoCuenta tipoCuenta,
            Moneda moneda,
            Cliente cliente
    ) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.estadoCuenta = EstadoCuenta.ACTIVA;
        this.saldo = new Dinero(BigDecimal.ZERO, moneda);
        this.cliente = cliente;
        this.movimientos = new ArrayList<>();
    }

    // Constructor para reconstruir desde BD (mapper)
    public static Cuenta reconstruir(
            NumeroCuenta numeroCuenta,
            TipoCuenta tipoCuenta,
            EstadoCuenta estado,
            Dinero saldo,
            Cliente cliente,
            List<Movimiento> movimientos
    ) {
        Cuenta cuenta = new Cuenta(numeroCuenta, tipoCuenta, saldo.getMoneda(), cliente);
        cuenta.estadoCuenta = estado;
        cuenta.saldo = saldo;
        cuenta.movimientos = movimientos != null ? new ArrayList<>(movimientos) : new ArrayList<>();
        return cuenta;
    }


    // Getters
    public NumeroCuenta getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public Dinero getSaldo() {
        return saldo;
    }

    public Moneda getMoneda() {
        return saldo.getMoneda();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Movimiento> getMovimientos() {
        return Collections.unmodifiableList(movimientos);
    }

    // Operaciones
    public void depositar(Dinero monto) {
        validarActiva();
        validarMonto(monto);
        validarMoneda(monto);

        saldo = saldo.sumar(monto);
        registrarMovimiento(monto, TipoMovimiento.DEPOSITO, "Depósito en cuenta");
    }

    public void extraer(Dinero monto) {
        validarActiva();
        validarMonto(monto);
        validarMoneda(monto);
        validarSaldoSuficiente(monto);

        saldo = saldo.restar(monto);
        registrarMovimiento(monto, TipoMovimiento.EXTRACCION, "Extracción de cuenta");
    }

    public void transferir(Cuenta cuentaDestino, Dinero monto, String referencia) {
        if (cuentaDestino == null) {
            throw new IllegalArgumentException("La cuenta destino no puede ser nula");
        }

        if (this.numeroCuenta.equals(cuentaDestino.getNumeroCuenta())) {
            throw new IllegalArgumentException("No se puede transferir a la misma cuenta");
        }

        // Validaciones en cuenta origen
        validarActiva();
        validarMonto(monto);
        validarMoneda(monto);
        validarSaldoSuficiente(monto);

        // Validaciones en cuenta destino
        cuentaDestino.validarActiva();
        cuentaDestino.validarMoneda(monto);

        // Ejecutar transferencia
        this.saldo = this.saldo.restar(monto);
        cuentaDestino.saldo = cuentaDestino.saldo.sumar(monto);

        // Registrar movimientos en ambas cuentas
        String descripcionOrigen = String.format("Transferencia a cuenta %s - Ref: %s",
            cuentaDestino.getNumeroCuenta(), referencia);
        String descripcionDestino = String.format("Transferencia desde cuenta %s - Ref: %s",
            this.numeroCuenta, referencia);

        this.registrarMovimiento(monto, TipoMovimiento.TRANSFERENCIA, descripcionOrigen);
        cuentaDestino.registrarMovimiento(monto, TipoMovimiento.TRANSFERENCIA, descripcionDestino);
    }

    public void bloquear() {
        if (estadoCuenta == EstadoCuenta.CERRADA) {
            throw new CuentaNoOperableException("No se puede bloquear una cuenta cerrada");
        }
        estadoCuenta = EstadoCuenta.BLOQUEADA;
    }

    public void desbloquear() {
        if (estadoCuenta == EstadoCuenta.BLOQUEADA) {
            estadoCuenta = EstadoCuenta.ACTIVA;
        }
    }

    public void cerrar() {
        if (!saldo.getMonto().equals(BigDecimal.ZERO)) {
            throw new CuentaNoOperableException("No se puede cerrar una cuenta con saldo");
        }
        estadoCuenta = EstadoCuenta.CERRADA;
    }

    public boolean isActiva() {
        return estadoCuenta == EstadoCuenta.ACTIVA;
    }

    public boolean isBloqueada() {
        return estadoCuenta == EstadoCuenta.BLOQUEADA;
    }

    public boolean isCerrada() {
        return estadoCuenta == EstadoCuenta.CERRADA;
    }

    // Validaciones privadas
    private void validarActiva() {
        if (estadoCuenta != EstadoCuenta.ACTIVA) {
            throw new CuentaNoOperableException(
                String.format("Estado actual: %s", estadoCuenta)
            );
        }
    }

    private void validarSaldoSuficiente(Dinero monto) {
        if (monto.getMonto().compareTo(this.saldo.getMonto()) > 0) {
            throw new SaldoInsuficienteException();
        }
    }

    private void validarMonto(Dinero monto) {
        if (monto.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MontoInvalidoException();
        }
    }

    private void validarMoneda(Dinero monto) {
        if (!this.saldo.getMoneda().equals(monto.getMoneda())) {
            throw new IllegalArgumentException(
                String.format("La moneda debe ser %s", this.saldo.getMoneda())
            );
        }
    }

    private void registrarMovimiento(Dinero monto, TipoMovimiento tipo, String descripcion) {
        Movimiento movimiento = new Movimiento(tipo, monto, descripcion, this);
        movimientos.add(movimiento);
    }
}