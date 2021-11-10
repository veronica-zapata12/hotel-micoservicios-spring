package com.hotel.reservas.dominio.servicios;

import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.puerto.dao.DaoHabitaciones;

import java.util.List;
import java.util.Optional;

public class ServicioConsultarHabitaciones {
    private final DaoHabitaciones daoHabitaciones;

    public ServicioConsultarHabitaciones(DaoHabitaciones daoHabitaciones) {
        this.daoHabitaciones = daoHabitaciones;
    }
   public List<HabitacionesDto> listarHabitacionesPorEstado(String estado){
        return this.daoHabitaciones.obtenerHabitacionesPorEstado(estado);
    }
}
