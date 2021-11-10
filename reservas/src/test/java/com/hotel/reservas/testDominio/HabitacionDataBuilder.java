package com.hotel.reservas.testDominio;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;

public class HabitacionDataBuilder {
    private static final Long IDHABITACION= Long.valueOf(101);
    private static final int CAPACIDAD=1;
    private static final Double NUMEROCAMAS=2.0;
    private static final Double PRECIO=25000.0;
    private static final String ESTADO="libre";

    private long idHabitacion;
    private int capacidad;
    private Double numeroCamas;
    private  Double precio;
    private String estado;

    public HabitacionDataBuilder() {
        this.idHabitacion=IDHABITACION;
        this.capacidad=CAPACIDAD;
        this.numeroCamas=NUMEROCAMAS;
        this.precio=PRECIO;
        this.estado=ESTADO;
    }
    public Habitaciones build(){
        return new Habitaciones(this.idHabitacion,this.capacidad,this.numeroCamas,this.precio,this.estado);
    }
}
