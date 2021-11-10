package com.hotel.personas.infraestructura.adaptador.repositorio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntidad {
    @Id
    @Column
    private int id;

    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private int telefono;
    @Column
    private String Email;
}
