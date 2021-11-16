package com.hotel.reservas.aplicacion.consulta;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservas;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorConsultaReservaPorId {
    private final ServicioConsultarReservas servicioConsultarReservas;



    public ManejadorConsultaReservaPorId(ServicioConsultarReservas servicioConsultarReservas) {
        this.servicioConsultarReservas = servicioConsultarReservas;
    }

    public Optional<ReservaDto> ejecutar(Long id){
        return this.servicioConsultarReservas.listarReservaId(id);
    }
}
