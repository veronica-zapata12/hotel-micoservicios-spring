package com.hotel.reservas.dominio.modelo.entidad;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Habitaciones {
    private long idHabitacion;
    private int capacidad;
    private Double numeroCamas;
    private  Double precio;
    private String estado;

}
