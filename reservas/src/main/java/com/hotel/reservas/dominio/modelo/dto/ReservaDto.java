package com.hotel.reservas.dominio.modelo.dto;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDto {
    private static final String EL_ID_PERSONA_ES_OBLIGATORIO="el id de la persona es obligatorio";
    private static final String LA_FECHA_INICIO_ES_OBLIGATORIO="la fecha de inicio es obligatorio";
    private static final String LA_FECHA_FIN_ES_OBLIGATORIO="la fecha fin es obligatorio";
    private long idReserva;
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;
    private int dias;
    private HabitacionesDto habitacion;
}
