package com.hotel.personas.aplicacion.comando.manejador;



import com.hotel.personas.aplicacion.comando.ComandoPersona;
import com.hotel.personas.aplicacion.comando.fabrica.FabricaPersona;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.dominio.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona {

    private final ServicioCrearPersona servicioCrearPersona;
    private final FabricaPersona fabricaPersona;

    public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {
        this.servicioCrearPersona = servicioCrearPersona;
        this.fabricaPersona = fabricaPersona;
    }
    public  void ejecutar(ComandoPersona comandoPersona){
        Personas personas= this.fabricaPersona.crear(comandoPersona);
        this.servicioCrearPersona.ejecutar(personas);
    }
}
