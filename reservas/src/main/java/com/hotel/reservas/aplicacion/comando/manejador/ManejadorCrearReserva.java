package com.hotel.reservas.aplicacion.comando.manejador;

import com.hotel.reservas.aplicacion.comando.ComandoReserva;
import com.hotel.reservas.aplicacion.comando.fabrica.FabricaReserva;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.servicios.ServicioCrearReserva;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ManejadorCrearReserva {
    private final ServicioCrearReserva servicioCrearReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva = fabricaReserva;
    }
    public void ejecutar(ComandoReserva comandoReserva)  {
        Reserva reserva=this.fabricaReserva.crear(comandoReserva);
        this.servicioCrearReserva.ejecutar(reserva);
    }
}
