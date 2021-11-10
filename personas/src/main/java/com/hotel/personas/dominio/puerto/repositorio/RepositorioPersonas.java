package com.hotel.personas.dominio.puerto.repositorio;


import com.hotel.personas.dominio.modelo.entidad.Personas;

public interface RepositorioPersonas {
    void crear(Personas personas);
    boolean existe(Personas personas);
}
