package com.hotel.facturas.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException{

 public ExcepcionCampoObligatorio(String mensaje){
     super(mensaje);
 }
}
