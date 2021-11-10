package com.hotel.reservas.aplicacion.comando.fabrica;

import com.hotel.reservas.aplicacion.comando.ComandoReserva;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva)  {

        return new Reserva(
                comandoReserva.getIdPersona(),
                comandoReserva.getFechaInicio(),
                comandoReserva.getFechaFin(),
                comandoReserva.getHabitacion()
        );
    }
}
