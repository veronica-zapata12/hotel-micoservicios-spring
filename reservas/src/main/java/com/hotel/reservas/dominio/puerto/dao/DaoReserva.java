package com.hotel.reservas.dominio.puerto.dao;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;

import java.util.List;
import java.util.Optional;

public interface DaoReserva {
    List<ReservaDto> obtenerTodos();
    Optional<ReservaDto> getReservaById(Long idReserva);
    Optional<List<ReservaDto>> getReservaByIdPersona(int idPersona);

}
