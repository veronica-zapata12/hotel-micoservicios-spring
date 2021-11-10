package com.hotel.personas.testInfraestructura;

import com.hotel.personas.aplicacion.comando.ComandoPersona;
import com.hotel.personas.dominio.modelo.entidad.Personas;
import com.hotel.personas.testDominio.PersonaDataBuilder;

public class ComandoPersonaDataBuilder {
    private static final int ID=1234567;
    private static final String NOMBRE="juan";
    private static final String DIRECCION ="calle 12";
    private static final int TELEFONO =123456;
    private static final String EMAIL="juan@juan";
    private int id;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;


    public ComandoPersonaDataBuilder() {
        this.id= ID;
        this.nombre=NOMBRE;
        this.direccion = DIRECCION;
        this.telefono = TELEFONO;
        this.email=EMAIL;

    }
    public ComandoPersonaDataBuilder sinNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public ComandoPersonaDataBuilder sinEmail(String email){
        this.email =email;
        return this;
    }


    public ComandoPersonaDataBuilder conId(int id){
        this.id =id;
        return this;
    }
    public ComandoPersona build(){
        return new ComandoPersona(this.id,this.nombre,this.direccion,this.telefono,this.email);
    }
}
