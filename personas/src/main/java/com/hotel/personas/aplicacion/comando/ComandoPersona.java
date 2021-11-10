package com.hotel.personas.aplicacion.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ComandoPersona {
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;


}
