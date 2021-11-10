package com.hotel.reservas.testInfraestructura;

import com.hotel.reservas.aplicacion.comando.ComandoReserva;
import com.hotel.reservas.dominio.modelo.entidad.Habitaciones;
import com.hotel.reservas.dominio.modelo.entidad.Reserva;
import com.hotel.reservas.testDominio.HabitacionDataBuilder;
import com.hotel.reservas.testDominio.ReservaDataBuilder;

import java.util.Calendar;
import java.util.Date;

public class ComandoReservaDataBuilder {
    private static final int IDPERSONA=1234;
    private static final Date FECHAINICIO= new Date();
    private static final Date FECHAFIN= new Date();
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;
    private Habitaciones habitacion;

    public ComandoReservaDataBuilder() {
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
    /*public ComandoReservaDataBuilder sinFechaInicial(Date fecha){
        this.fechaInicio=fecha;
        return this;
    }
    public ComandoReservaDataBuilder sinFechaFinal(Date fecha){
        this.fechaFin=fecha;
        return this;
    }*/
    public ComandoReserva build(){
        return new ComandoReserva(this.idPersona,this.fechaInicio,this.fechaFin,this.habitacion);
    }

}
