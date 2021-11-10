package com.hotel.personas.dominio.servicio;


import com.hotel.personas.dominio.excepcion.ExcepcionDuplicidad;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.dominio.puerto.repositorio.RepositorioPersonas;

public class ServicioCrearPersona {
    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";
    private final RepositorioPersonas repositorioPersonas;

    public ServicioCrearPersona(RepositorioPersonas repositorioPersonas) {
        this.repositorioPersonas = repositorioPersonas;
    }
    public void ejecutar(Personas personas){
        validarExistencia(personas);
        this.repositorioPersonas.crear(personas);

    }
    private void validarExistencia(Personas personas){
        boolean existe=this.repositorioPersonas.existe(personas);
        if (existe){
            throw  new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
