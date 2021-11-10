package com.hotel.personas.aplicacion.consulta;


import com.hotel.personas.dominio.modelo.dto.PersonasDto;
import com.hotel.personas.dominio.servicio.ServicioConsultarPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarPersonas {
    private final ServicioConsultarPersona servicioConsultarPersona;

    public ManejadorConsultarPersonas(ServicioConsultarPersona servicioConsultarPersona) {
        this.servicioConsultarPersona = servicioConsultarPersona;
    }
    public List<PersonasDto> ejecutar(){
        return this.servicioConsultarPersona.listarPersonas();
    }
}
