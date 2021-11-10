package com.hotel.reservas.infraestructura.adaptador.repositorio;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioHabitaciones;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.HabitacionEntidad;
import com.hotel.reservas.infraestructura.repositorioJpa.HabitacionRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHabitacionesPostgres implements RepositorioHabitaciones{
    private ModelMapper modelMapper = new ModelMapper();
    private final HabitacionRepositorioJpa habitacionRepositorioJpa;

    public RepositorioHabitacionesPostgres(HabitacionRepositorioJpa habitacionRepositorioJpa) {
        this.habitacionRepositorioJpa = habitacionRepositorioJpa;
    }

    @Override
    public void cambiarEstado(Habitaciones habitaciones) {
        HabitacionEntidad habitacionEntidad=modelMapper.map(habitaciones,HabitacionEntidad.class);
        this.habitacionRepositorioJpa.save(habitacionEntidad);

    }
}
