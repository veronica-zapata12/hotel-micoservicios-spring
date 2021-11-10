package com.hotel.personas.testDominio;

import com.hotel.personas.dominio.modelo.entidad.Personas;

public class PersonaDataBuilder {
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


    public PersonaDataBuilder() {
        this.id= ID;
        this.nombre=NOMBRE;
        this.direccion = DIRECCION;
        this.telefono = TELEFONO;
        this.email=EMAIL;

    }
    public PersonaDataBuilder sinNombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public PersonaDataBuilder sinEmail(String email){
        this.email =email;
        return this;
    }


    public PersonaDataBuilder idCorto(int id){
        this.id =id;
        return this;
    }
    public Personas build(){
        return new Personas(this.id,this.nombre,this.direccion,this.telefono,this.email);
    }
}
