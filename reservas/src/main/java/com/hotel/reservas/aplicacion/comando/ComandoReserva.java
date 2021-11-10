package com.hotel.reservas.aplicacion.comando;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import lombok.Getter;

import java.util.Date;
@Getter
public class ComandoReserva {
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;
    private int dias;
    private Habitaciones habitacion;

    public ComandoReserva(int idPersona, Date fechaIncio, Date fechaFin, Habitaciones habitacion) {
        this.idPersona = idPersona;
        this.fechaInicio = fechaIncio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
    }
}
