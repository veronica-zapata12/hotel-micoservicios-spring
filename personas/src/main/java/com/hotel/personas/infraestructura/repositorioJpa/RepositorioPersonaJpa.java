package com.hotel.personas.infraestructura.repositorioJpa;



import com.hotel.personas.infraestructura.adaptador.repositorio.entidades.PersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface RepositorioPersonaJpa extends JpaRepository<PersonaEntidad, Serializable> {
    //@Query(value = "select * from persona where persona.id = :id ", nativeQuery = true)
    PersonaEntidad findById(@Param("id") int id);

}
