package com.hotel.reservas.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HabitacionesDto {
    private long idHabitacion;
    private int capacidad;
    private Double numeroCamas;
    private  Double precio;
    private String estado;
}
