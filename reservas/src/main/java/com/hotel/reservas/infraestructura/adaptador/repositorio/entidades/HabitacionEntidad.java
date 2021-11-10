package com.hotel.reservas.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habitaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionEntidad {
    @Id
    @Column(name = "id")
    private long idHabitacion;
    private int capacidad;
    @Column(name = "numero_camas")
    private Double numeroCamas;
    private  Double precio;
    private String estado;
}
