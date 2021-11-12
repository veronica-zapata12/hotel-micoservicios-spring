package com.hotel.reservas.dominio.modelo.dto;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ReservaDto {
    private long idReserva;
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;
    private int dias;
    private HabitacionesDto habitacion;
    private PersonasDto persona;

    public ReservaDto(long idReserva, int idPersona, Date fechaInicio, Date fechaFin, int dias, HabitacionesDto habitacion) {
        this.idReserva = idReserva;
        this.idPersona = idPersona;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dias = dias;
        this.habitacion = habitacion;
    }
}
