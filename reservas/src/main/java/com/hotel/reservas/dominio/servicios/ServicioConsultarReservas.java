package com.hotel.reservas.dominio.servicios;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;

import java.util.List;
import java.util.Optional;

public class ServicioConsultarReservas {
    private final DaoReserva daoReserva;

    public ServicioConsultarReservas(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }
   public Optional<ReservaDto> listarReservaId(Long idReserva){
        return this.daoReserva.getReservaById(idReserva);
    }
   public List<ReservaDto> listarTodo(){
        return this.daoReserva.obtenerTodos();
    }
}
