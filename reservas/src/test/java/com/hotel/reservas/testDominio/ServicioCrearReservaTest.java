package com.hotel.reservas.testDominio;

import com.hotel.reservas.dominio.excepcion.ExcepcionFecha;
import com.hotel.reservas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioHabitaciones;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioReserva;
import com.hotel.reservas.dominio.servicios.ServicioCrearReserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {
    private RepositorioReserva repositorioReserva;
    private RepositorioHabitaciones repositorioHabitaciones;
    private ServicioCrearReserva servicioCrearReserva;
    @BeforeEach
    public void init() {
        repositorioHabitaciones=Mockito.mock(RepositorioHabitaciones.class);
        repositorioReserva = Mockito.mock(RepositorioReserva.class);
        servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,repositorioHabitaciones);

    }

    @Test
    @DisplayName("Deberia crear correctamente la reserva")
    void crearReserva() {
        Reserva reserva=new ReservaDataBuilder().build();
        Mockito.when(repositorioReserva.existe(reserva)).thenReturn(false);
        repositorioHabitaciones.cambiarEstado(reserva.getHabitacion());
        servicioCrearReserva.ejecutar(reserva);
        Assertions.assertEquals(1234,reserva.getIdPersona());
        Assertions.assertEquals(1,reserva.getDias());
    }

    @Test
    void crearReservaSinFechaInicio() {
        Assertions.assertThrows(ExcepcionFecha.class, () ->
                new ReservaDataBuilder().sinFechaInicial(null).build(), "la fecha de inicio es obligatorio");
    }
    @Test
    void crearReservaSinFechaFin() {
        Assertions.assertThrows(ExcepcionFecha.class, () ->
                new ReservaDataBuilder().sinFechaFinal(null).build(), "la fecha fin es obligatorio");
    }
    @Test
    void crearReservaHabitacionNoDisponible() {
        Reserva reserva=new ReservaDataBuilder().build();
        Mockito.when(repositorioReserva.existe(reserva)).thenReturn(true);
        Assertions.assertThrows(ExcepcionGeneral.class, () ->
                servicioCrearReserva.ejecutar(reserva), "la habitacion se encuentra ocupada para esa fecha");
    }
}
