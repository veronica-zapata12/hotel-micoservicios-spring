package com.hotel.personas.aplicacion.comando.fabrica;


import com.hotel.personas.aplicacion.comando.ComandoPersona;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import org.springframework.stereotype.Component;

@Component
public class FabricaPersona {

    public Personas crear(ComandoPersona comandoPersona){
        return new Personas(comandoPersona.getId(), comandoPersona.getNombre(),comandoPersona.getDireccion(),comandoPersona.getTelefono(), comandoPersona.getEmail());
    }
}
