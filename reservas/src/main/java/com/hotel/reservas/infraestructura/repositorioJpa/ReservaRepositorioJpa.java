package com.hotel.reservas.infraestructura.repositorioJpa;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public interface ReservaRepositorioJpa extends JpaRepository<ReservaEntidad, Serializable> {
    ReservaEntidad findByIdReserva(Long idReserva);



}
