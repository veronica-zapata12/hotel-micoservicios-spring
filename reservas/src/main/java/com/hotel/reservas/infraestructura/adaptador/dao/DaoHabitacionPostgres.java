package com.hotel.reservas.infraestructura.adaptador.dao;

import com.hotel.reservas.dominio.modelo.dto.HabitacionesDto;
import com.hotel.reservas.dominio.puerto.dao.DaoHabitaciones;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.HabitacionEntidad;
import com.hotel.reservas.infraestructura.repositorioJpa.HabitacionRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DaoHabitacionPostgres implements DaoHabitaciones {
    private ModelMapper modelMapper = new ModelMapper();
    private final HabitacionRepositorioJpa  habitacionRepositorioJpa;

    public DaoHabitacionPostgres(HabitacionRepositorioJpa habitacionRepositorioJpa) {
        this.habitacionRepositorioJpa = habitacionRepositorioJpa;
    }

    @Override
    public List<HabitacionesDto> obtenerHabitacionesPorEstado(String estado) {
        List<HabitacionEntidad> habitacionEntidadList=this.habitacionRepositorioJpa.findByEstadoOrderByIdHabitacion(estado);
        List<HabitacionesDto> habitacionesDtoList=new ArrayList<>();
        for (HabitacionEntidad habitacionEntidad:habitacionEntidadList){
            HabitacionesDto habitacionesDto=modelMapper.map(habitacionEntidad,HabitacionesDto.class);
            habitacionesDtoList.add(habitacionesDto);
        }
        return habitacionesDtoList;
    }

    @Override
    public HabitacionesDto buscarPorId(Long idHabitacion) {
        HabitacionEntidad habitacionEntidad=this.habitacionRepositorioJpa.findByIdHabitacion(idHabitacion);
        HabitacionesDto habitacionesDto=modelMapper.map(habitacionEntidad,HabitacionesDto.class);
        return habitacionesDto;
    }
}
