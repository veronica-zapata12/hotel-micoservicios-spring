package com.hotel.reservas.aplicacion.consulta;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservas;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultarReservas {
    private final ServicioConsultarReservas servicioConsultarReservas;

    public ManejadorConsultarReservas(ServicioConsultarReservas servicioConsultarReservas) {
        this.servicioConsultarReservas = servicioConsultarReservas;
    }
    public List<ReservaDto> ejecutar(){
        return this.servicioConsultarReservas.listarTodo();
    }
}
