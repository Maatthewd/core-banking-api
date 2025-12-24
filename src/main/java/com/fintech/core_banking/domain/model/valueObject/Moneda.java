package com.fintech.core_banking.domain.model.valueObject;

public enum Moneda {

    ARG("Peso Argentino", 2),
    USD("Dolar Estadounidense", 2),
    EUR("Euro", 2);


    private final String descripcion;
    private final int decimales;

    Moneda(String descripcion, int decimales) {
        this.descripcion = descripcion;
        this.decimales = decimales;
    }

    public int getDecimales() {
        return decimales;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
