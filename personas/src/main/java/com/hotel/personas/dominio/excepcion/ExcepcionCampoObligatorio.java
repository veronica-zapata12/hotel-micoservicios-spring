package com.hotel.personas.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException{

 public ExcepcionCampoObligatorio(String mensaje){
     super(mensaje);
 }
}
