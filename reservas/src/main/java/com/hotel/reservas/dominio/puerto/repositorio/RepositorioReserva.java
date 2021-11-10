package com.hotel.reservas.dominio.puerto.repositorio;

import com.hotel.reservas.dominio.modelo.entidad.Reserva;

import java.text.ParseException;
import java.util.Date;

public interface RepositorioReserva {
    void save(Reserva reserva);
    boolean existe(Reserva reserva) ;

}
