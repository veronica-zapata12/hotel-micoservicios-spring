package com.hotel.reservas.dominio.servicios;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;


import java.util.List;
import java.util.Optional;

public class ServicioConsultarReservasPorIdPersona {
    private final DaoReserva daoReserva;

    public ServicioConsultarReservasPorIdPersona(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }
    public Optional<List<ReservaDto>> reservaByIdPersona(int idPersona){
        return daoReserva.getReservaByIdPersona(idPersona);
    }
}

