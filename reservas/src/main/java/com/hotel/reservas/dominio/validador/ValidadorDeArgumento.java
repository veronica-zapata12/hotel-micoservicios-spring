package com.hotel.reservas.dominio.validador;


import com.hotel.reservas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.hotel.reservas.dominio.excepcion.ExcepcionFecha;


import java.util.Date;

public class ValidadorDeArgumento {
    public ValidadorDeArgumento() {
    }
    public static void validarObligatorio(String valor, String mensaje) {
        if (valor == null) {
            {
                throw new ExcepcionCampoObligatorio(mensaje);
            }
        }
    }
    public static void validarFecha(Date fecha, String mensaje) {
        if (fecha==null) {
            {
                throw new ExcepcionFecha(mensaje);
            }

            }

    }
}
