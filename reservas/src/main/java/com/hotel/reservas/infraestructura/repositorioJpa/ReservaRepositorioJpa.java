package com.hotel.reservas.infraestructura.repositorioJpa;


import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;

import java.util.List;


public interface ReservaRepositorioJpa extends JpaRepository<ReservaEntidad, Serializable> {
    ReservaEntidad findByIdReserva(Long idReserva);
    List<ReservaEntidad> findByIdPersona(int idPersona);




}
