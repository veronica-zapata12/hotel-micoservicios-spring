package com.hotel.personas.dominio.validador;


import com.hotel.personas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.hotel.personas.dominio.excepcion.ExcepcionLongitud;

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
    public static void validarLongitud(int id, String mensaje) {
        if (Integer.toString(id).length() < 5 || Integer.toString(id).length() > 10) {
            {
                throw new ExcepcionLongitud(mensaje);
            }

            }

    }
}
