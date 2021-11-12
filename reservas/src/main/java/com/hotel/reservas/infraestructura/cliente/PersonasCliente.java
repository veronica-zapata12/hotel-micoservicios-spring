package com.hotel.reservas.infraestructura.cliente;

import com.hotel.reservas.dominio.modelo.dto.PersonasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "personas-service",fallback = PersonasHystrixFallbackFactory.class)
public interface PersonasCliente {
    @GetMapping(value = "/personas/{id}")
    ResponseEntity<PersonasDto> buscarPorId(@PathVariable int id);
}
