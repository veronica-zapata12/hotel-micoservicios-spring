package com.hotel.facturas.dominio.excepcion;

public class ExcepcionLongitud extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionLongitud(String mensaje) {
        super(mensaje);
    }
}
