package com.hotel.reservas.testDominio;


import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.puerto.dao.DaoHabitaciones;
import com.hotel.reservas.dominio.servicios.ServicioConsultarHabitaciones;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ServicioConsultarHabitacionesTest {
    private DaoHabitaciones daoHabitaciones;
    private ServicioConsultarHabitaciones servicioConsultarHabitaciones;
    @BeforeEach
    public void init() {

        daoHabitaciones = Mockito.mock(DaoHabitaciones.class);
        servicioConsultarHabitaciones = new ServicioConsultarHabitaciones(daoHabitaciones);
    }
    @Test
    @DisplayName("Deberia listar las habitaciones por estado ")
    void listarTodasReservas() {
        List<HabitacionesDto> habitacionesDtoList=new ArrayList<>();
        Habitaciones habitaciones=new HabitacionDataBuilder().build();
        HabitacionesDto habitacionesDto=new HabitacionesDto(habitaciones.getIdHabitacion(),habitaciones.getCapacidad(),habitaciones.getNumeroCamas(), habitaciones.getPrecio(), habitaciones.getEstado());
       habitacionesDtoList.add(habitacionesDto);
        Mockito.when(daoHabitaciones.obtenerHabitacionesPorEstado(habitaciones.getEstado())).thenReturn(habitacionesDtoList);
        List<HabitacionesDto> habitacionesDtoList1=servicioConsultarHabitaciones.listarHabitacionesPorEstado(habitaciones.getEstado());
        Assertions.assertEquals(1, habitacionesDtoList1.size());

    }
}
