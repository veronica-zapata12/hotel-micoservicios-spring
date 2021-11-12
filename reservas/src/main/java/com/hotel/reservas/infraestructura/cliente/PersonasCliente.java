package com.hotel.reservas.infraestructura.cliente;

import com.hotel.reservas.dominio.modelo.dto.PersonasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "personas-service")
@RequestMapping(value = "/personas")
public interface PersonasCliente {
    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonasDto> buscarPorId(@PathVariable int id);
}
