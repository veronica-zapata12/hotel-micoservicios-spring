package com.hotel.reservas.dominio.modelo.entidad;

import com.hotel.reservas.dominio.validador.ValidadorDeArgumento;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Getter
public class Reserva {
    private static final String EL_ID_PERSONA_ES_OBLIGATORIO="el id de la persona es obligatorio";
    private static final String LA_FECHA_INICIO_ES_OBLIGATORIO="la fecha de inicio es obligatorio";
    private static final String LA_FECHA_FIN_ES_OBLIGATORIO="la fecha fin es obligatorio";
    private long idReserva;
    private int idPersona;
    private Date fechaInicio;
    private Date fechaFin;
    private int dias;
    private Habitaciones habitacion;
    private Double total;

    public Reserva( int idPersona, Date fechaIncio, Date fechaFin, Habitaciones habitaciones) {
        ValidadorDeArgumento.validarObligatorio(String.valueOf (idPersona),EL_ID_PERSONA_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarFecha(fechaIncio,LA_FECHA_INICIO_ES_OBLIGATORIO);
        ValidadorDeArgumento.validarFecha(fechaFin,LA_FECHA_FIN_ES_OBLIGATORIO);
        this.idPersona = idPersona;
        this.fechaInicio = fechaIncio;
        this.fechaFin = fechaFin;
        this.habitacion = habitaciones;
        this.dias=this.calcularDias(this.fechaInicio,this.fechaFin);
        this.total=this.totalPorDias(dias,habitaciones.getPrecio());
    }

    private int calcularDias(Date fechaIncio, Date fechaFin) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        formato.format(fechaIncio);
        formato.format(fechaFin);
        long startTime = fechaIncio.getTime() ;
        long endTime = fechaFin.getTime();
        int diasDesde = (int) Math.floor(startTime / (1000*60*60*24)); // convertimos a dias, para que no afecten cambios de hora
        int diasHasta = (int) Math.floor(endTime / (1000*60*60*24)); // convertimos a dias, para que no afecten cambios de hora
        int dias = (int) (diasHasta - diasDesde);

        return dias;

    }
    private double totalPorDias(int dias, double valor){
        return dias*valor;
    }
}

