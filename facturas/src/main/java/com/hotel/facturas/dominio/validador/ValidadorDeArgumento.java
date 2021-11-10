package com.hotel.facturas.dominio.validador;





import com.hotel.facturas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.hotel.facturas.dominio.excepcion.ExcepcionFecha;

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
