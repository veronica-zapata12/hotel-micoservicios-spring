package com.hotel.personas.testDominio;

import com.hotel.personas.dominio.excepcion.ExcepcionCampoObligatorio;
import com.hotel.personas.dominio.excepcion.ExcepcionDuplicidad;
import com.hotel.personas.dominio.excepcion.ExcepcionGeneral;
import com.hotel.personas.dominio.excepcion.ExcepcionLongitud;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.dominio.puerto.repositorio.RepositorioPersonas;
import com.hotel.personas.dominio.servicio.ServicioCrearPersona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearPersonaTest {
    private RepositorioPersonas repositorioPersonas;

    private ServicioCrearPersona servicioCrearPersona;

    @BeforeEach
    public void init() {

        repositorioPersonas = Mockito.mock(RepositorioPersonas.class);
        servicioCrearPersona = new ServicioCrearPersona(repositorioPersonas);
    }
    @Test
    public void crearProducto(){
        Personas personas=new PersonaDataBuilder().build();
        servicioCrearPersona.ejecutar(personas);
        Assertions.assertEquals("juan",personas.getNombre());
        Assertions.assertEquals(123456,personas.getTelefono());
        Assertions.assertEquals("juan@juan",personas.getEmail());

    }
    @Test
    public void crearPersonaExistente(){
        Personas personas=new PersonaDataBuilder().build();
    Mockito.when(repositorioPersonas.existe(personas)).thenReturn(true);
        Assertions.assertThrows(ExcepcionDuplicidad.class, () ->
                servicioCrearPersona.ejecutar(personas), "La persona ya existe en el sistema");

    }
    @Test
    public void crearPersonaSinNombre(){
        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new PersonaDataBuilder().sinNombre(null).build(), "el nombre es obligatorio");

    }
    @Test
    public void crearPersonaSinEmail(){
        Assertions.assertThrows(ExcepcionCampoObligatorio.class, () ->
                new PersonaDataBuilder().sinEmail(null).build(), "el email es obligatorio");

    }

    @Test
    public void crearPersonaConIdCorto(){
        Assertions.assertThrows(ExcepcionLongitud.class, () ->
                new PersonaDataBuilder().idCorto(12).build(), "el id debe ser mayor a 5 y menor que 10");

    }


}
