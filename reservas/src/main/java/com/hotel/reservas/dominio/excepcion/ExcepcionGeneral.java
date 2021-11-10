package com.hotel.reservas.dominio.excepcion;

public class ExcepcionGeneral extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionGeneral(String mensaje) {
        super(mensaje);
    }

}
