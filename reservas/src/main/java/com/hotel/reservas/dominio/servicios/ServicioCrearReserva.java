package com.hotel.reservas.dominio.servicios;


import com.hotel.reservas.dominio.excepcion.ExcepcionDuplicidad;
import com.hotel.reservas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioHabitaciones;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioReserva;


public class ServicioCrearReserva {
    private static final String LA_HABITACION_SE_ENCUENTRA_OCUPADA= "la habitacion se encuentra ocupada";
    private final RepositorioReserva repositorioReserva;
    private final RepositorioHabitaciones repositorioHabitaciones;


    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHabitaciones repositorioHabitaciones) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioHabitaciones = repositorioHabitaciones;

    }

    public void ejecutar(Reserva reserva) {
        validarHabitacionPorFecha(reserva);
        this.repositorioReserva.save(reserva);
        Habitaciones habitaciones = reserva.getHabitacion();
        habitaciones.setEstado("ocupado");
        this.repositorioHabitaciones.cambiarEstado(habitaciones);
    }
    private void validarHabitacionPorFecha(Reserva reserva) {
        boolean existe =this.repositorioReserva.existe(reserva);
        if(existe) {
            throw new ExcepcionGeneral(LA_HABITACION_SE_ENCUENTRA_OCUPADA);
        }
    }

}
