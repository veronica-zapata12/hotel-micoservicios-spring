package com.hotel.reservas.infraestructura.repositorioJpa;

import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.HabitacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;


public interface HabitacionRepositorioJpa extends JpaRepository<HabitacionEntidad, Serializable> {

    List<HabitacionEntidad> findByEstadoOrderByIdHabitacion(String estado);
    HabitacionEntidad findByIdHabitacion(Long idHabitacion);
}
