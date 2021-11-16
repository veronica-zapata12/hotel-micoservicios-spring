package com.hotel.reservas.aplicacion.consulta;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservasPorIdPersona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ManejadorConsultaReservaPorIdPersona {
    private final ServicioConsultarReservasPorIdPersona servicioConsultarReservasPorIdPersona;

    public ManejadorConsultaReservaPorIdPersona(ServicioConsultarReservasPorIdPersona servicioConsultarReservasPorIdPersona) {
        this.servicioConsultarReservasPorIdPersona = servicioConsultarReservasPorIdPersona;
    }
    public Optional<List<ReservaDto>> ejecutar(int id){
        return this.servicioConsultarReservasPorIdPersona.reservaByIdPersona(id);
    }
}
