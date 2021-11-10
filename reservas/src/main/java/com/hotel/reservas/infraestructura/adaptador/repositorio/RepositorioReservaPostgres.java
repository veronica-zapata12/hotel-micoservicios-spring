package com.hotel.reservas.infraestructura.adaptador.repositorio;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.dominio.puerto.repositorio.RepositorioReserva;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.HabitacionEntidad;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.ReservaEntidad;
import com.hotel.reservas.infraestructura.repositorioJpa.HabitacionRepositorioJpa;
import com.hotel.reservas.infraestructura.repositorioJpa.ReservaRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaPostgres implements RepositorioReserva {
    private final ModelMapper modelMapper = new ModelMapper();
    private final ReservaRepositorioJpa reservaRepositorioJpa;
    private final HabitacionRepositorioJpa habitacionRepositorioJpa;

    public RepositorioReservaPostgres(ReservaRepositorioJpa reservaRepositorioJpa, HabitacionRepositorioJpa habitacionRepositorioJpa) {
        this.reservaRepositorioJpa = reservaRepositorioJpa;
        this.habitacionRepositorioJpa = habitacionRepositorioJpa;
    }

    @Override
    public void save(Reserva reserva) {
        Habitaciones habitaciones = reserva.getHabitacion();
        HabitacionEntidad habitacionEntidad = modelMapper.map(habitaciones, HabitacionEntidad.class);
        ReservaEntidad reservaEntidad = modelMapper.map(reserva, ReservaEntidad.class);
        reservaEntidad.setHabitacionEntidad(habitacionEntidad);
        this.habitacionRepositorioJpa.save(habitacionEntidad);
        this.reservaRepositorioJpa.save(reservaEntidad);
    }


    @Override
    public boolean existe(Reserva reserva) {
        HabitacionEntidad habitacionEntidad = this.habitacionRepositorioJpa.findByIdHabitacion(reserva.getHabitacion().getIdHabitacion());
        String estado = habitacionEntidad.getEstado();
        boolean existe = (estado.equals("ocupado")) ? true : false;
        return existe;
    }
}
