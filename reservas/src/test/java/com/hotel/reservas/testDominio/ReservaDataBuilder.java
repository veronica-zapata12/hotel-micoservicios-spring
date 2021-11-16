package com.hotel.reservas.testDominio;

import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.Calendar;
import java.util.Date;

public class ReservaDataBuilder {
    private static final int IDPERSONA=123456;
    private static final Date FECHAINICIO= new Date();
    private static final Date FECHAFIN= new Date();
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;

    private Habitaciones habitacion;


    public ReservaDataBuilder() {
        this.idPersona= IDPERSONA;
        this.fechaInicio=FECHAINICIO;

        this.fechaFin=getfecha(FECHAFIN);
        this.habitacion=new HabitacionDataBuilder().build();
    }
    public  Date getfecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();

    }
  public ReservaDataBuilder sinFechaInicial(Date fecha){
        this.fechaInicio=fecha;
        return this;
  }
    public ReservaDataBuilder sinFechaFinal(Date fecha){
        this.fechaFin=fecha;
        return this;
    }
    public Reserva build(){
        return new Reserva(this.idPersona,this.fechaInicio,this.fechaFin,this.habitacion);
    }
}
