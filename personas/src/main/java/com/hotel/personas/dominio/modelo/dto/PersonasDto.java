package com.hotel.personas.dominio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonasDto {
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String Email;

}
