package com.hotel.personas.dominio.servicio;

import com.hotel.personas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.personas.dominio.modelo.dto.PersonasDto;
import com.hotel.personas.dominio.puerto.dao.DaoPersonas;

import java.util.List;

public class ServicioConsultarPersona {
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona Nno existe en el sistema";
    private final DaoPersonas daoPersonas;


    public ServicioConsultarPersona(DaoPersonas daoPersonas) {
        this.daoPersonas = daoPersonas;

    }
    public PersonasDto buscarporId(int id){
        boolean existeId=this.daoPersonas.existeId(id);
        if (!existeId) {
          throw  new ExcepcionGeneral(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }else {
            return this.daoPersonas.buscarPorId(id);
        }
    }

    public List<PersonasDto> listarPersonas(){
        return this.daoPersonas.listarPersonas();
    }

}
