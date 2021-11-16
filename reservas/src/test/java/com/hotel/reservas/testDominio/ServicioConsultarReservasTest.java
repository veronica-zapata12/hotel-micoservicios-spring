package com.hotel.reservas.testDominio;

import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioConsultarReservasTest {
    private DaoReserva daoReserva;
    private ServicioConsultarReservas servicioConsultarReservas;
    @BeforeEach
    public void init() {

        daoReserva = Mockito.mock(DaoReserva.class);
        servicioConsultarReservas = new ServicioConsultarReservas(daoReserva);
    }
    @Test
    @DisplayName("Deberia listar todas las reservas correctamente ")
    void listarTodasReservas() {
        List<ReservaDto> reservaDtoList=new ArrayList<>();
        Reserva reserva=new ReservaDataBuilder().build();
        Habitaciones habitaciones=new HabitacionDataBuilder().build();
        HabitacionesDto habitacionesDto=new HabitacionesDto(habitaciones.getIdHabitacion(),habitaciones.getCapacidad(),habitaciones.getNumeroCamas(), habitaciones.getPrecio(), habitaciones.getEstado());
        ReservaDto reservaDto=new ReservaDto(reserva.getIdReserva(), reserva.getIdPersona(), reserva.getFechaInicio(),reserva.getFechaFin(), reserva.getDias(), habitacionesDto, reserva.getTotal());
        reservaDtoList.add(reservaDto);
        Mockito.when(daoReserva.obtenerTodos()).thenReturn(reservaDtoList);
        List<ReservaDto> reservaDtoList1=servicioConsultarReservas.listarTodo();
        Assertions.assertEquals(1, reservaDtoList.size());

    }
    @Test
    @DisplayName("Deberia listar la reserva por el id")
    void listarReservasPorId() {
        Reserva reserva=new ReservaDataBuilder().build();
        Habitaciones habitaciones=new HabitacionDataBuilder().build();
        HabitacionesDto habitacionesDto=new HabitacionesDto(habitaciones.getIdHabitacion(),habitaciones.getCapacidad(),habitaciones.getNumeroCamas(), habitaciones.getPrecio(), habitaciones.getEstado());
        ReservaDto reservaDto=new ReservaDto(reserva.getIdReserva(), reserva.getIdPersona(), reserva.getFechaInicio(),reserva.getFechaFin(), reserva.getDias(), habitacionesDto,reserva.getTotal());

        Mockito.when(daoReserva.getReservaById(reserva.getIdReserva())).thenReturn(Optional.of(reservaDto));
        Optional<ReservaDto> reservaDto1=servicioConsultarReservas.listarReservaId(reserva.getIdReserva());
        Assertions.assertEquals(123456,reservaDto1.get().getIdPersona());
        Assertions.assertEquals(1,reservaDto1.get().getDias());
        Assertions.assertEquals(101,reservaDto1.get().getHabitacion().getIdHabitacion());
    }
}
