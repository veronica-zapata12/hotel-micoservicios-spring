package com.hotel.reservas.infraestructura.configuracion;

import com.hotel.reservas.dominio.puerto.dao.DaoHabitaciones;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioHabitaciones;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioReserva;
import com.hotel.reservas.dominio.servicios.ServicioConsultarHabitaciones;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservas;
import com.hotel.reservas.dominio.servicios.ServicioConsultarReservasPorIdPersona;
import com.hotel.reservas.dominio.servicios.ServicioCrearReserva;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHabitaciones repositorioHabitaciones){
    return new ServicioCrearReserva(repositorioReserva,repositorioHabitaciones);
}
    @Bean
    public ServicioConsultarReservas servicioConsultarReservas (DaoReserva daoReserva){
    return new ServicioConsultarReservas( daoReserva);
}
    @Bean
    public ServicioConsultarHabitaciones servicioConsultarHabitaciones(DaoHabitaciones daoHabitaciones){
    return new ServicioConsultarHabitaciones(daoHabitaciones);
}
    @Bean
    public ServicioConsultarReservasPorIdPersona servicioConsultarReservasPorIdPersona(DaoReserva daoReserva){
        return new ServicioConsultarReservasPorIdPersona(daoReserva);
    }


	

}
