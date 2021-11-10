package com.hotel.reservas.dominio.puerto.dao;

import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;

import java.util.List;
import java.util.Optional;

public interface DaoHabitaciones {
    List<HabitacionesDto>obtenerHabitacionesPorEstado(String estado);
    HabitacionesDto buscarPorId(Long idHabitacion);
}
