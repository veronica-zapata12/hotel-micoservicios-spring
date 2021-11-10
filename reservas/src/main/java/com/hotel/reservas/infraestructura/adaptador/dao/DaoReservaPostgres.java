package com.hotel.reservas.infraestructura.adaptador.dao;

import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.ReservaEntidad;
import com.hotel.reservas.infraestructura.repositorioJpa.ReservaRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class DaoReservaPostgres implements DaoReserva {
    private ModelMapper modelMapper = new ModelMapper();
    private final ReservaRepositorioJpa reservaRepositorioJpa;

    public DaoReservaPostgres(ReservaRepositorioJpa reservaRepositorioJpa) {
        this.reservaRepositorioJpa = reservaRepositorioJpa;
    }


    @Override
    public List<ReservaDto> obtenerTodos() {
        List<ReservaEntidad> reservaEntidadList=this.reservaRepositorioJpa.findAll();
        List<ReservaDto> reservaDtoList=new ArrayList<>();
        for (ReservaEntidad reservaEntidad:reservaEntidadList){
            ReservaDto reservaDto=modelMapper.map(reservaEntidad,ReservaDto.class);
            reservaDtoList.add(reservaDto);
        }
        return reservaDtoList;
    }

    @Override
    public ReservaDto getReservaById(Long idReserva) {
        ReservaEntidad reservaEntidad=this.reservaRepositorioJpa.findByIdReserva(idReserva);
        ReservaDto reservaDto=modelMapper.map(reservaEntidad,ReservaDto.class);
        return reservaDto;

    }
}
