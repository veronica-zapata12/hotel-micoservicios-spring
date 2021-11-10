package com.hotel.reservas.dominio.puerto.dao;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;

import java.util.List;

public interface DaoReserva {
    List<ReservaDto> obtenerTodos();
    ReservaDto getReservaById(Long idReserva);

}
