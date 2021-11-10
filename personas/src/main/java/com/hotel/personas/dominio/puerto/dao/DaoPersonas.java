package com.hotel.personas.dominio.puerto.dao;


import com.hotel.personas.dominio.modelo.dto.PersonasDto;

import java.util.List;

public interface DaoPersonas {
    PersonasDto buscarPorId(int id);
    List<PersonasDto> listarPersonas();
    boolean existeId(int id);
}
