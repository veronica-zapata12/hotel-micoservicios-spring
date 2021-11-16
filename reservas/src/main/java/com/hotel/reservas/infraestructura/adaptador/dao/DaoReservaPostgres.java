package com.hotel.reservas.infraestructura.adaptador.dao;

import com.hotel.reservas.dominio.modelo.dto.PersonasDto;
import com.hotel.reservas.dominio.modelo.dto.ReservaDto;
import com.hotel.reservas.dominio.puerto.dao.DaoReserva;
import com.hotel.reservas.infraestructura.adaptador.repositorio.entidades.ReservaEntidad;
import com.hotel.reservas.infraestructura.cliente.PersonasCliente;
import com.hotel.reservas.infraestructura.repositorioJpa.ReservaRepositorioJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class DaoReservaPostgres implements DaoReserva {
    private ModelMapper modelMapper = new ModelMapper();
    private final ReservaRepositorioJpa reservaRepositorioJpa;
   
    @Autowired
    PersonasCliente personasCliente;

    public DaoReservaPostgres(ReservaRepositorioJpa reservaRepositorioJpa) {
        this.reservaRepositorioJpa = reservaRepositorioJpa;
    }


    @Override
    public List<ReservaDto> obtenerTodos() {
        List<ReservaEntidad> reservaEntidadList=this.reservaRepositorioJpa.findAll();
        List<ReservaDto> reservaDtoList=new ArrayList<>();
        for (ReservaEntidad reservaEntidad:reservaEntidadList){
            ReservaDto reservaDto=modelMapper.map(reservaEntidad,ReservaDto.class);
            PersonasDto  personasDto=personasCliente.buscarPorId(reservaEntidad.getIdPersona()).getBody();
           reservaDto.setPersona(personasDto);
            reservaDtoList.add(reservaDto);
        }
        return reservaDtoList;
    }

    @Override
    public Optional<ReservaDto> getReservaById(Long idReserva) {
        ReservaEntidad reservaEntidad=this.reservaRepositorioJpa.findByIdReserva(idReserva);
        ReservaDto reservaDto = null;
        if (null != reservaEntidad){
            reservaDto=modelMapper.map(reservaEntidad,ReservaDto.class);
            PersonasDto personaDto=  personasCliente.buscarPorId(reservaEntidad.getIdPersona()).getBody();
            reservaDto.setPersona(personaDto);

        }
      return null!=reservaDto? Optional.of(reservaDto): Optional.empty();
    }

    @Override
    public Optional<List<ReservaDto>> getReservaByIdPersona(int idPersona) {
        List<ReservaEntidad> reservaEntidadList=this.reservaRepositorioJpa.findByIdPersona(idPersona);
        List<ReservaDto> reservaDtoList=new ArrayList<>();
        for (ReservaEntidad reservaEntidad:reservaEntidadList){
            ReservaDto reservaDto=modelMapper.map(reservaEntidad,ReservaDto.class);
            PersonasDto  personasDto=personasCliente.buscarPorId(reservaEntidad.getIdPersona()).getBody();
            reservaDto.setPersona(personasDto);
            reservaDtoList.add(reservaDto);
        }
        return null!=reservaDtoList? Optional.of(reservaDtoList): Optional.empty();
    }
}
