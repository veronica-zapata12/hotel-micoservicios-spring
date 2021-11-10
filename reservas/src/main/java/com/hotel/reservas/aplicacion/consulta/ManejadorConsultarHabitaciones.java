package com.hotel.reservas.aplicacion.consulta;

import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.servicios.ServicioConsultarHabitaciones;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarHabitaciones {
    private final ServicioConsultarHabitaciones servicioConsultarHabitaciones;

    public ManejadorConsultarHabitaciones(ServicioConsultarHabitaciones servicioConsultarHabitaciones) {
        this.servicioConsultarHabitaciones = servicioConsultarHabitaciones;
    }
    public List<HabitacionesDto> ejecutar(String estado){
        return this.servicioConsultarHabitaciones.listarHabitacionesPorEstado(estado);
    }
}
