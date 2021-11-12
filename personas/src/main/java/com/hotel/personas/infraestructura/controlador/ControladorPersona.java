package com.hotel.personas.infraestructura.controlador;


import com.hotel.personas.aplicacion.comando.ComandoPersona;
import com.hotel.personas.aplicacion.comando.manejador.ManejadorCrearPersona;
import com.hotel.personas.aplicacion.consulta.ManejadorConsultaPersonaPorId;
import com.hotel.personas.aplicacion.consulta.ManejadorConsultarPersonas;
import com.hotel.personas.dominio.modelo.dto.PersonasDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personas")
public class ControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorConsultaPersonaPorId manejadorConsultaPersonaPorId;
    private final ManejadorConsultarPersonas manejadorConsultarPersonas;

    public ControladorPersona(ManejadorCrearPersona manejadorCrearPersona, ManejadorConsultaPersonaPorId manejadorConsultaPersonaPorId, ManejadorConsultarPersonas manejadorConsultarPersonas) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorConsultaPersonaPorId = manejadorConsultaPersonaPorId;
        this.manejadorConsultarPersonas = manejadorConsultarPersonas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crear(@RequestBody ComandoPersona comandoPersona){
        this.manejadorCrearPersona.ejecutar(comandoPersona);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonasDto> buscarPorId(@PathVariable int id){

        return new ResponseEntity<>(this.manejadorConsultaPersonaPorId.ejecutar(id),HttpStatus.OK);
    }

    @GetMapping

    public ResponseEntity<List<PersonasDto>> listar(){
        return new ResponseEntity<>(this.manejadorConsultarPersonas.ejecutar(),HttpStatus.OK);
    }
}
