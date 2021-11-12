package com.hotel.reservas.infraestructura.cliente;

import com.hotel.reservas.dominio.modelo.dto.PersonasDto;
import org.springframework.http.ResponseEntity;

public class PersonasHystrixFallbackFactory implements PersonasCliente{
    @Override
    public ResponseEntity<PersonasDto> buscarPorId(int id) {
        PersonasDto personasDto=new PersonasDto(0,null,null,0,null);
        return ResponseEntity.ok(personasDto);
    }
}
