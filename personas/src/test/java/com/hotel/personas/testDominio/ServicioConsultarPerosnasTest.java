package com.hotel.personas.testDominio;

import com.hotel.personas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.personas.dominio.modelo.dto.PersonasDto;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.dominio.puerto.dao.DaoPersonas;
import com.hotel.personas.dominio.puerto.repositorio.RepositorioPersonas;
import com.hotel.personas.dominio.servicio.ServicioConsultarPersona;
import com.hotel.personas.dominio.servicio.ServicioCrearPersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicioConsultarPerosnasTest {
    private DaoPersonas daoPersonas;
    private ServicioConsultarPersona servicioConsultarPersona;
    @BeforeEach
    public void init() {

        daoPersonas = Mockito.mock(DaoPersonas.class);
        servicioConsultarPersona = new ServicioConsultarPersona(daoPersonas);
    }
    @Test
    public void listarTodos(){
        List<PersonasDto> personaDtoLista= new ArrayList<>();
        Personas personas=new PersonaDataBuilder().build();
        PersonasDto personaDto=new PersonasDto(personas.getId(), personas.getNombre(),personas.getDireccion(),personas.getTelefono(),personas.getEmail() );
        personaDtoLista.add(personaDto);

        Mockito.when(daoPersonas.listarPersonas()).thenReturn(personaDtoLista);

        List<PersonasDto> personaDtoList= servicioConsultarPersona.listarPersonas();
        Assertions.assertEquals(1, personaDtoList.size());

    }

    @Test
    public void listarPorId(){
        Personas personas=new PersonaDataBuilder().build();
        PersonasDto personaDto=new PersonasDto(personas.getId(), personas.getNombre(),personas.getDireccion(),personas.getTelefono(),personas.getEmail() );
        Mockito.when(daoPersonas.existeId(personaDto.getId())).thenReturn(true);
        Mockito.when(daoPersonas.buscarPorId(personas.getId())).thenReturn(personaDto);
        PersonasDto personaDto1= servicioConsultarPersona.buscarporId(personaDto.getId());
        Assertions.assertEquals(1234567, personaDto1.getId());
        Assertions.assertEquals("juan",personaDto1.getNombre());
        Assertions.assertEquals("calle 12", personaDto1.getDireccion());
        Assertions.assertEquals(123456,personaDto1.getTelefono());
        Assertions.assertEquals("juan@juan",personaDto1.getEmail());
    }
    @Test
    public void consultarPersonaNoExistente(){

        Assertions.assertThrows(ExcepcionGeneral.class, () ->
                servicioConsultarPersona.buscarporId(122), "La persona Nno existe en el sistema");

    }

}
