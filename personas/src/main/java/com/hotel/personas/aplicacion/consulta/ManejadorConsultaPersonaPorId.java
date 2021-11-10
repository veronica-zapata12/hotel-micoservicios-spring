package com.hotel.personas.aplicacion.consulta;


import com.hotel.personas.dominio.modelo.dto.PersonasDto;
import com.hotel.personas.dominio.servicio.ServicioConsultarPersona;
import org.springframework.stereotype.Component;


@Component
public class ManejadorConsultaPersonaPorId {
    private final ServicioConsultarPersona servicioConsultarPersona;

    public ManejadorConsultaPersonaPorId(ServicioConsultarPersona servicioConsultarPersona) {
        this.servicioConsultarPersona = servicioConsultarPersona;
    }
    public PersonasDto ejecutar(int id){
        return this.servicioConsultarPersona.buscarporId(id);
    }
}
